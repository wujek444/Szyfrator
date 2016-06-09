package szyfrator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class KodCezara{
    static int przesuniecie;
    static public String napis;
    static char[] tablicaZnakow;
    static char[] alfabet = new char[26];
//    static char[] alfabet = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G'
//    ,'h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P','q','Q'
//    ,'r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z'};
    static Scanner skaner = new Scanner(System.in);
    KodCezara() {
        for(int i=0; i<26; i++){
                alfabet[i] = (char) ('a' + (char)i);
        }
//        for(int i=1; i<26; i+=2){
//            if(i==1){
//                alfabet[i] = (char)('A' + (char)(i-1));    
//            }else alfabet[i] = (char)('A' + (char)(i)); 
//        }
    }
    void ustawPrzesuniecie(int i){
        przesuniecie = i;
    }
    static void drukujAlfabet(){
        for(int i=0; i<26; i++){
            System.out.println(alfabet[i]);
        }
    }
    void wprowadzNapis(){
        System.out.print("Wprowadz napis: ");
        napis = skaner.nextLine();
    }
    void wyswietlNapis(){
        System.out.println("Napis: " + napis);
    }
    static void szyfruj(){
        tablicaZnakow = napis.toCharArray();
        for(int i=0; i<napis.length(); i++){
            if(tablicaZnakow[i] != ' '){
                for(int j=0; j<26; j++){
                    if(tablicaZnakow[i] == alfabet[j]){
                        if((j+przesuniecie)<26){
                            tablicaZnakow[i] = alfabet[j+przesuniecie];
                            break;
                        }else{
                            int k = j + przesuniecie - 26;
                            tablicaZnakow[i] = alfabet[k];
                            break;
                        }
                    }
                }
            }
        }
        napis = new String(tablicaZnakow);
    }
    static void odszyfruj(){
        tablicaZnakow = napis.toCharArray();
        for(int i=0; i<napis.length(); i++){
            if(tablicaZnakow[i] != ' ') {
                for(int j=0; j<26; j++){
                    if(tablicaZnakow[i] == alfabet[j]){
                        if((j-przesuniecie)>=0){
                            tablicaZnakow[i] = alfabet[j-przesuniecie];
                            break;
                        }else{
                            int k = j - przesuniecie + 25;
                            tablicaZnakow[i] = alfabet[k+1];
                            break;
                        }
                    }
                }
            }
        }
        napis = new String(tablicaZnakow);
    }
        
}
