package com.singelton;

public class Singelton {
    //can have only one object ar instance of the class at a time
    //make constructor as private
    //write a static method (getInstance) that  has return type of object of this singelton class (Lazy Initialization)
    //difference between normal class and singlton - normal class
    // uses constructor for creation of instance and singelton uses public method related to private constractor
    private static Singelton singelton_instance = null;
    public String str;

    private Singelton() {
       str = "I am using Singelton class pattern";
    }

    public static Singelton getInstance(){
        if (singelton_instance==null)
            singelton_instance = new Singelton();
        return singelton_instance;


    }

    public static void main(String[] args) {
       Singelton x = Singelton.getInstance();
       Singelton y = Singelton.getInstance();//return the same object
       Singelton z = Singelton.getInstance();//return the same object

        x.str = (x.str).toUpperCase();
        System.out.println(x.str);
        System.out.println(y.str);
        System.out.println(z.str);

        z.str = (z.str).toLowerCase(); //object will be the same again
        System.out.println(x.str);
        System.out.println(y.str);
        System.out.println(z.str);
    }
}
