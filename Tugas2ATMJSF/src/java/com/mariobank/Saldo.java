/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariobank;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author jonat
 */
@Named
@RequestScoped
public class Saldo{
    private static Saldo instance = new Saldo();
    private static int saldo = 500000;
    private static int minSaldo = 100000;
    private int jumlahTarik;
    private int jumlahSetor;
    
    private Saldo(){}
    
    public static Saldo getInstance(){
        return instance;
    }
    
    public void setJumlahTarik(int s){
        this.jumlahTarik = s;
    }
    
    public int getJumlahTarik(){
        return this.jumlahTarik;
    }
    
    public void setJumlahSetor(int s){
        this.jumlahSetor = s;
    }
    
    public int getJumlahSetor(){
        return this.jumlahSetor;
    }
    
    public void setSaldo(int s){
        this.saldo = s;
    }
    
    public int getSaldo(){
        return this.saldo;
    }
    
    public void setMinSaldo(int s){
        this.minSaldo = s;
    }
    
    public int getMinSaldo(){
        return this.minSaldo;
    }
}