package ru.rzn.sbr.javaschool.lesson10.cars;


public class TrafficController {
    private int counter = 0;

    public synchronized void enterLeft() {
        while (counter > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        counter++;
        System.out.println("Car from left is passing");


    }

    public synchronized void enterRight() {
        while (counter > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;


    }

    public synchronized void leaveLeft() {
        counter=0;
        notify();
    }

    public synchronized void leaveRight() {
        counter = 0;

        System.out.println("Car from left is passed");
        notify();
    }
}