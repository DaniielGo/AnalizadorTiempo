/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnaapp;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;





public class JnaApp {

   public static void main(String[] args) {
       while(true){ 
        System.out.println("title is " + getActiveWindowTitle());
       }
    }

    private static String getActiveWindowTitle() {
        HWND fgWindow = User32.INSTANCE.GetForegroundWindow();
        int titleLength = User32.INSTANCE.GetWindowTextLength(fgWindow) + 1;
        char[] title = new char[titleLength];
        User32.INSTANCE.GetWindowText(fgWindow, title, titleLength);
        return Native.toString(title);
    }

}

