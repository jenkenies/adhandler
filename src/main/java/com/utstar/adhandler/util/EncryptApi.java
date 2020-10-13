/*
 * @(#)EncryptApi.java  2003/11/28
 *
 * Copyright (c) 2003 UTStarcom, Inc. All Rights Reserved.
 *
 */

/**
 * Please change the package as one proper name.
 */
package com.utstar.adhandler.util;

/**
 * Internet Data Encrypt Algorithm
 *
 * There are two static method to be invoked: encryptPassword and decryptPassword.
 *          String s1 = EncryptApi.encryptPassword("wacos");
 *          String s2 = EncryptApi.decryptPassword(s1);
 *
 * @author Alexandre Qin, Bright Deng
 */

public class EncryptApi {

  private  final int IDEA_ROUNDS = 8;        /* Number of IDEA rounds  */
  private  final int IDEA_SK_NUM = (6 * IDEA_ROUNDS + 4);  /* Number of IDEA subkeys */

  private static final int MUL_MOD = ((1 << 16) | 1);
  private boolean isgenKey = false; //whether call pkey or not
  private int pkey[][] = new int[1][8];
  private int enpkey[] = new int[IDEA_SK_NUM];
  private int depkey[] = new int[IDEA_SK_NUM];
  private int data[] = new int[4];

  private int LSW16(int y)
  {
    int l16y = y & 0xffff;
    return l16y;
  }

  private int MSW16(int y)
  {
    int m16y = (y>>>16) & 0xffff;
    return m16y;
  }

  /*
   * Multiplication modulo 2**16 + 1
   */
  private int mul( int x, int y)
  {
    int q;
    int p;

    if (x == 0)
      return LSW16(MUL_MOD - y);
    else if (y == 0)
      return LSW16(MUL_MOD - x);
    else {
      q = x * y;
      p = LSW16(q) - MSW16(q);
      if (p <=  0) p +=  MUL_MOD;
      return LSW16(p);
    }
  }

  /*
   * Compute multiplicative inverse of x by Euclid's GCD algorithm.
   */
  private int mul_inv(int x)
  {
    int n1 = MUL_MOD;
    int n2 = x;
    int b1 = 0;
    int b2 = 1;
    int q, r, t;

    if (x <=  1) return x;
    while (true) {
      r = n1 % n2;
      q = n1 / n2;
      if (r == 0) {
        if (b2 < 0) b2 +=  MUL_MOD;
        return LSW16(b2);
      } else {
        n1 = n2;
        n2 = r;
        t = b2;
        b2 = b1 - q * b2;
        b1 = t;
      }
    }
  } /* mul_inv */


  /*
   * Computes IDEA encryption subkeys.
   */
  private void idea_encrypt_subkeys(int pKey[], int subkeys[])
  {
    int i;

    for (i = 0; i<8; i++) subkeys[i] = pKey[i];
    for (; i<IDEA_SK_NUM; i++)
      subkeys[i] = LSW16((subkeys[(((i+1) % 0x8)>0) ? i-7 : i-15] << 9) |
              (subkeys[(i+2) % 0x8 < 2 ? i-14 : i-6] >>> 7));
  } /* idea_encrypt_subkeys */


  /*
   * Computes IDEA decryption subkeys from encryption subkeys.
   */
  private void idea_decrypt_subkeys( int en_subkeys[], int de_subkeys[])
  {
    int t[] = new int[IDEA_SK_NUM];
    int i;
    int pen = 0;

    t[6 * IDEA_ROUNDS] = mul_inv(en_subkeys[pen++]);
    t[6 * IDEA_ROUNDS + 1] = LSW16(-1 * en_subkeys[pen++] );
    t[6 * IDEA_ROUNDS + 2] = LSW16(-1 * en_subkeys[pen++] );
    t[6 * IDEA_ROUNDS + 3] = mul_inv(en_subkeys[pen++]);
    for (i = 6*(IDEA_ROUNDS-1); i>= 0; i-= 6) {
      t[i + 4] = en_subkeys[pen++];
      t[i + 5] = en_subkeys[pen++];
      t[i] = mul_inv(en_subkeys[pen++]);
      if (i!= 0) {
        t[i + 2] = LSW16(-1 * en_subkeys[pen++] );
        t[i + 1] = LSW16(-1 * en_subkeys[pen++] );
      } else {
        t[1] = LSW16(-1 * en_subkeys[pen++] );
        t[2] = LSW16(-1 * en_subkeys[pen++] );
      }
      t[i + 3] = mul_inv(en_subkeys[pen++]);
    }

    for (i = 0;i<IDEA_SK_NUM;i++) {
      de_subkeys[i] = t[i];
      t[i] = 0;
    }
  } /* idea_decrypt_subkey */


  /*
   * IDEA encryption/decryption algorithm.
   * Note: block_in and block_out can be the same block.
   */
  private void idea_cipher(int block_in[], int block_out[], int pKey[])
  {
    int word1, word2, word3, word4;
    int t1, t2;
    int i;
    int pin = 0, pout = 0, pk = 0;
    word1 = block_in[pin++];
    word2 = block_in[pin++];
    word3 = block_in[pin++];
    word4 = block_in[pin];

    for (i = IDEA_ROUNDS; i>0; i--) {
      word1 = mul(word1, pKey[pk++]);
      word2 = LSW16(word2+pKey[pk++]);
      word3 = LSW16(word3 + pKey[pk++]);
      word4 = mul(word4, pKey[pk++]);

      t2 = word1 ^ word3;
      t2 = mul(t2, pKey[pk++]);
      t1 = LSW16(t2 + (word2 ^ word4));
      t1 = mul(t1, pKey[pk++]);
      t2 = LSW16(t1 + t2);

      word1 ^=  t1;
      word4 ^=  t2;

      t2 ^=  word2;
      word2 = word3 ^ t1;
      word3 = t2;
    }

    word1 = mul(word1, pKey[pk++]);
    block_out[pout++] = word1;
    block_out[pout++] = LSW16(word3 + pKey[pk++]);
    block_out[pout++] = LSW16(word2 + pKey[pk++]);
    word4 = mul(word4, pKey[pk]);
    block_out[pout] = word4;
  }

  /*
   * Construct key
   */
  private void constructKey()
  {
    for (int i = 0;i<8;i++) {
      pkey[0][i] =  (i+2)*2+1000;
    }

  }

  /*
   * Construct encrypt key
   */
  private void getEncryptKey()
  {
    idea_encrypt_subkeys(pkey[0], enpkey);
  }

  /*
   * Construct decrypt key
   */
  private void getDecryptKey()
  {
    idea_decrypt_subkeys(enpkey, depkey);
  }

  /*
   * call IDEA algorithm to encrypt source block
   */
  private void encrypt(int source[], int dest[])
  {
    idea_cipher(source, dest, enpkey);
    int iLoop = 0;
    while(true){
      if (dest[iLoop] < 256 || (dest[iLoop] % 256 )  ==  0) {
        idea_cipher(dest, dest, enpkey);
        iLoop = 0;
      } else {
        iLoop++;
        if (iLoop  ==  4) break;
      }
    }
  }

  /*
   * call IDEA algorithm to decrypt dest block
   */
  private void decrypt(int dest[], int source[])
  {
    idea_cipher(dest, source, depkey);

    int iLoop = 0;
    while (true) {
      //if( (source[iLoop] !=  0) &&
      //  ( (source[iLoop] < 256) || (source[iLoop] % 256  ==  0) )){
      if (source[iLoop] < 256 || (source[iLoop] % 256 )  ==  0) {
        idea_cipher(source, source, depkey);
        iLoop = 0;
      } else {
        iLoop++;
        if (iLoop  ==  4) break;
      }
    }
  }

  /*
   * get a block to encrypt or decrypt
   */
  private void getBlock(StringBuffer pcSource)
  {
    char cHigh, cLow;
    int iLength = pcSource.length();
    int iLoop = 0, iBegin = 0;
    while (iLoop < 4) {
      if (iBegin < iLength)
        cHigh = pcSource.charAt(iBegin++);
      else
        cHigh = 32;
      if (iBegin < iLength)
        cLow  = pcSource.charAt(iBegin++);
      else
        cLow = 32;

      data[iLoop] = cHigh*256 + cLow;
      iLoop++;
    }
  }

  /*
   * get a block to encrypt or decrypt
   */
  private void getBlock(StringBuffer pcSource, int iLength)
  {
    char cHigh, cLow;
    int iLoop = 0, iBegin = 0;
    while(iLoop < 4){
      if(iBegin < iLength)
        cHigh = pcSource.charAt(iBegin++);
      else
        cHigh = 32;
      if(iBegin < iLength)
        cLow  = pcSource.charAt(iBegin++);
      else
        cLow = 32;

      data[iLoop] = cHigh*256 + cLow;
      iLoop++;
    }
  }

  /*
   * Construct the chararaters to the string buffer.
   */
  private void returnToChar(StringBuffer pcString)
  {
    char cHigh, cLow;
    char cTmp[] = new char[2];
    for(int i = 0; i<4; i++) {
      cHigh = (char)(data[i] / 256);
      cLow  = (char)(data[i] % 256);

      cTmp[0] = (char)(cHigh & 0xFF);
      cTmp[1] = (char)(cLow & 0xFF);
      pcString.append(cTmp);
    }
  }

  /*
   * Encrypt to one string based on ISO-8859-1 charset encoded.
   */
  private String encrypt(StringBuffer pcSource)
  {
    if (pcSource  ==  null)
      return null;

    if (isgenKey  ==  false) {
      constructKey();
      getEncryptKey();
      getDecryptKey();
      isgenKey = true;
    }

    StringBuffer pcDest = new StringBuffer("");
    StringBuffer pcTmp = pcSource;
    int iLength = pcTmp.length();

    while (iLength > 0) {
      getBlock(pcTmp);
      encrypt(data, data);
      returnToChar(pcDest);
      iLength -=  8;
      if (iLength < 0) break;
      pcTmp  = new StringBuffer(pcTmp.substring(8));//+=  8;
    }
    String endStr = new String();

    try {
      //byte[] ss = pcDest.toString().getBytes("ISO-8859-1");
      byte[] ss = new byte[pcDest.length()];
      for (int i=0; i<ss.length; i++) {
        ss[i] = (byte)pcDest.charAt(i);
      }
      endStr = new String(ss, "ISO-8859-1");
    } catch(Exception e) {
      System.err.print(e);
    }
    return endStr;
  }

  /*
   * Decrypt from one string based on ISO-8859-1 charset encoded.
   */
  private String decrypt(StringBuffer pcSource)
  {
    if (pcSource  ==  null)
      return null;

    if (isgenKey  ==  false) {
      constructKey();
      getEncryptKey();
      getDecryptKey();
      isgenKey = true;
    }

    StringBuffer pcDest = new StringBuffer("");
    StringBuffer pcTmp = pcSource;
    int iLength = pcTmp.length();

    while (iLength > 0) {
      getBlock(pcTmp);
      decrypt(data, data);
      returnToChar(pcDest);
      iLength -=  8;
      if (iLength < 0) break;
      pcTmp = new StringBuffer(pcTmp.substring(8));
    }
    String endStr = new String();
    try {
      //byte[] ss = pcDest.toString().getBytes("ISO8859_1");
      endStr = pcDest.toString().trim();
    } catch (Exception e) {
      System.err.print(e);
    }
    return endStr;
  }

  /**
   * Encrypt to one string based on ISO-8859-1 charset encoded.
   * @param source The source string to be encrypted. The source string is with the
   * platform's default charset encoded.
   * @return String The result after descrypted, with the ISO-8859-1 charset encoded.
   */
  public static String encryptPassword(String source)
  {
    EncryptApi encryptor = new EncryptApi();
    return encryptor.encrypt(new StringBuffer(source));
  }

  /**
   * Decrypt from one string based on ISO-8859-1 charset encoded.
   * @param source The source string to be decrypted. The source string should be with
   * ISO-8859-1 encoded.
   * @return String The result after decrypted, with the platform's default charset encoded.
   */
  public static String decryptPassword(String source)
  {
    EncryptApi encryptor = new EncryptApi();
    return encryptor.decrypt(new StringBuffer(source));
  }

  /**
   * Encrypt to one string with plain text based on ISO-8859-1 charset encoded.
   * @param source The source string to be encrypted. The source string is with the
   * platform's default charset encoded.
   * @return String The result after descrypted, with the ISO-8859-1 charset encoded.
   */
  public static String encryptPlainPassword(String source)
  {
    try {
      String s = encryptPassword(source);
      byte[] bs1 = s.getBytes("ISO-8859-1");
      byte[] bs2 = new byte[bs1.length * 2];
      for (int i =0; i<bs1.length; i++) {
        bs2[i*2] = (byte)(((bs1[i]+256)%256) / 16 + 65);
        bs2[i*2+1] = (byte)(((bs1[i]+256)%256) % 16 + 65);
      }
      return new String(bs2);
    } catch (Exception e) {
      return "";
    }
  }

  /**
   * Decrypt from one plain text string based on ISO-8859-1 charset encoded.
   * @param source The source string to be decrypted. The source string should be with
   * ISO-8859-1 encoded.
   * @return String The result after decrypted, with the platform's default charset encoded.
   */
  public static String decryptPlainPassword(String source)
  {
    try {
      byte[] bs1 = source.getBytes("ISO-8859-1");
      if (bs1.length % 2 == 1) {
        return "";
      }
      byte[] bs2 = new byte[bs1.length / 2];
      for (int i =0; i<bs2.length; i++) {
        bs2[i] = (byte)((bs1[i*2] - 65) * 16 + bs1[i*2+1] - 65);
      }
      String newSource = new String(bs2, "ISO-8859-1");
      EncryptApi encryptor = new EncryptApi();
      return encryptor.decrypt(new StringBuffer(newSource));
    } catch (Exception e) {
      return "";
    }
  }

  public static void printArray(String msg, int[] bs)
  {
    System.out.print(msg);
    for (int i =0; i<bs.length; i++) {
      System.out.print(" " + bs[i]);
    }
    System.out.println();
  }

  public static void test1(String s1)
  {
    try {
      String s2 = EncryptApi.encryptPassword(s1);
      System.out.println("The \"" + s1 + "\" after encrypt is:" + new String(s2.getBytes("ISO-8859-1")));

      System.out.print("The serial byte is:");
      byte[] bs = s2.getBytes("ISO-8859-1");
      for (int i =0; i<bs.length; i++) {
        System.out.print(" " + bs[i]);
      }
      System.out.println();

      String s3 = EncryptApi.decryptPassword(s2);
      System.out.println("The \"" + new String(s2.getBytes("ISO-8859-1")) + "\" after decrypt is:" + s3);

      System.out.print("The serial byte is:");
      bs = s3.getBytes();
      for (int i =0; i<bs.length; i++) {
        System.out.print(" " + bs[i]);
      }
      System.out.println();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void test2(String s1)
  {
    try {
      String s2 = EncryptApi.encryptPlainPassword(s1);
      System.out.println("The \"" + s1 + "\" after plain encrypt is:" + new String(s2.getBytes("ISO-8859-1")));

      System.out.print("The serial byte is:");
      byte[] bs = s2.getBytes("ISO-8859-1");
      for (int i =0; i<bs.length; i++) {
        System.out.print(" " + bs[i]);
      }
      System.out.println();

      String s3 = EncryptApi.decryptPlainPassword(s2);
      System.out.println("The \"" + new String(s2.getBytes("ISO-8859-1")) + "\" after plain decrypt is:" + s3);

      System.out.print("The serial byte is:");
      bs = s3.getBytes();
      for (int i =0; i<bs.length; i++) {
        System.out.print(" " + bs[i]);
      }
      System.out.println();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /** Main program entry point, for unit test.*/
  public static void main(String[] args)
          throws Exception
  {
    test1("wacos");
    test2("wacos");
    test1("11111304");
    test2("11111304");
  }

}
