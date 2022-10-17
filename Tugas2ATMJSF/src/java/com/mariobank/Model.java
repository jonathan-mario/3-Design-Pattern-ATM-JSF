/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariobank;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

/**
 *
 * @author jonat
 */
@Named
@RequestScoped
public class Model implements Dao{
    Saldo saldo = Saldo.getInstance();

    @Override
    public boolean limit(int tarik) {
        if((this.saldo.getSaldo() - tarik) < this.saldo.getMinSaldo()){
            return true;
        }else if(this.saldo.getSaldo() < this.saldo.getMinSaldo()){
            return true;
        }   
        return false;
    }
  
    public void setJumlahTarik(int s){
        this.saldo.setJumlahTarik(s);
    }
    
    public int getJumlahTarik(){
        return this.saldo.getJumlahTarik();
    }
    
    public void setJumlahSetor(int s){
        this.saldo.setJumlahSetor(s);
    }
    
    public int getJumlahSetor(){
        return this.saldo.getJumlahSetor();
    }

    public String submitTarik(){
        this.saldo.setSaldo(this.saldo.getSaldo() - this.saldo.getJumlahTarik());
        
        return "ceksaldo";
    }
    
    public String submitSetor(){
        this.saldo.setSaldo(this.saldo.getSaldo() + this.saldo.getJumlahSetor());
 
        return "ceksaldo";
    }
    
    public void tarikTunai(FacesContext cont, UIComponent comp, Object val){
        int tarik = Integer.parseInt(val.toString());

        if(tarik == 0){
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage("Tidak boleh 0");
            cont.addMessage("", message);
        }else if(tarik % 50000 != 0 ){
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage("Harus kelipatan 50000");
            cont.addMessage("", message);
        }else if(this.limit(tarik) ){
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage("Anda menarik melebihi limit saldo !!!" );
            cont.addMessage("", message);
        }
    }
    
    public void setorTunai(FacesContext cont, UIComponent comp, Object val){
        int setor = Integer.parseInt(val.toString());
        if(setor == 0){
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage("Tidak boleh 0");
            cont.addMessage("", message);
        }else if(setor % 50000 != 0 ){
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage("Harus kelipatan 50000");
            cont.addMessage("", message);
        }
    }
}


