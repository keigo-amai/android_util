package com.glpgs.ika.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringUtil {
    
    /**
     * Constructor.
     */
    private StringUtil() { }
    
    /**
     * .txt形式のファイルから、文字列を生成する.
     * @param in .txt形式ファイル (getAssets().open(.txt))
     * @param encode 
     * @return 文字列
     * @throws IOException 入出力に失敗場合は適切な文字をセットする.
     */
    public static String inputStreemToString(final InputStream in, String encode) throws IOException {
        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(in, encode));
        StringBuffer buf = new StringBuffer();
        String str;
        while ((str = reader.readLine()) != null) {
                buf.append(str);
                buf.append("\n");
        }
        String s = buf.toString();
        return  s.substring(0, s.length() - 1);
    }
}
