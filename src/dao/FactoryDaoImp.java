/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import OurQueue.Noded.Node;
//import OurQueue.Noded.Queue;
import dto.Robot;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serph
 */
public class FactoryDaoImp implements FactoryDao {
    
    //actúa como base de datos
    //public Queue factoryQueue = new Queue();
    public Queue<Robot> factoryQueue = new LinkedList();
    

    @Override
    public Queue GetAllData() {
        return factoryQueue;
    }

    @Override
    public void switchRobotId(int id1, int id2) {
        int index1 = 0;
        int index2 = 0;
        Robot r1 = new Robot();
        Robot r2 = new Robot();
        for (int i = 0; i < factoryQueue.size(); i++) {
            if(((Robot)factoryQueue.toArray()[i]).getId() == id1)
                index1 = i;
            if(((Robot)factoryQueue.toArray()[i]).getId() == id2)
                index2 = i;
        }
        if (index1 > index2){
            int x = index1;
            index1 = index2;
            index2 = x;
        }
        r1.setCanKillXHipsters(((Robot)factoryQueue.toArray()[index1]).getCanKillXHipsters());
        r1.setId(((Robot)factoryQueue.toArray()[index1]).getId());
        r1.setWeapon(((Robot)factoryQueue.toArray()[index1]).getWeapon());
        
        r2.setCanKillXHipsters(((Robot)factoryQueue.toArray()[index2]).getCanKillXHipsters());
        r2.setId(((Robot)factoryQueue.toArray()[index2]).getId());
        r2.setWeapon(((Robot)factoryQueue.toArray()[index2]).getWeapon());
        
        ((Robot)factoryQueue.toArray()[index1]).setCanKillXHipsters(r2.getCanKillXHipsters());
        ((Robot)factoryQueue.toArray()[index1]).setId(r2.getId());
        ((Robot)factoryQueue.toArray()[index1]).setWeapon(r2.getWeapon());
        
        ((Robot)factoryQueue.toArray()[index2]).setCanKillXHipsters(r1.getCanKillXHipsters());
        ((Robot)factoryQueue.toArray()[index2]).setId(r1.getId());
        ((Robot)factoryQueue.toArray()[index2]).setWeapon(r1.getWeapon());
    }

    @Override
    public void Create(Robot robot) {
        ValidateRegister(robot);
        factoryQueue.add(robot);
    }

    @Override
    public void AttendFirst() {
        factoryQueue.poll();
    }
    /*
    @Override
    public boolean DestroyById(int id) {
        for (int i = 0; i < factoryQueue.size(); i++) {
            Robot robot = (Robot)factoryQueue.toArray()[i]; 
            if (robot.getId() == id){
               return factoryQueue.remove((Robot)factoryQueue.toArray()[i]);
            }
        }
        return false;
    }*/    
    @Override
    public boolean DestroyById(int id) {
        return factoryQueue.remove((Robot)factoryQueue.toArray()[buscarPorId(factoryQueue,id, factoryQueue.size(),0)]);
    }
    
    //valida para que no hayan id repetidos
    private void ValidateRegister(Robot robot){
        for (int i = 0; i < factoryQueue.size(); i++) {
            if(((Robot)factoryQueue.toArray()[i]).getId() == (robot.getId()))
                throw new IllegalArgumentException("El producto ya está registrado.");
        }
    } 
    
    /*
    @Override
    public void SortById(int order) {
        for (int i = 0; i < factoryQueue.size(); i++) {
            for (int j = i + 1; j < factoryQueue.size(); j++) {
                
                Robot n1 = new Robot();
                Robot n2 = new Robot();
                
                boolean orderCondition = false;
                if(order == 0){
                    orderCondition = (((Robot)factoryQueue.toArray()[i]).getId()) > (((Robot)factoryQueue.toArray()[j]).getId());
                }else if(order == 1){
                    orderCondition = (((Robot)factoryQueue.toArray()[i]).getId()) < (((Robot)factoryQueue.toArray()[j]).getId());
                }
                if (orderCondition) {
                    
                    n1.setCanKillXHipsters(((Robot)factoryQueue.toArray()[i]).getCanKillXHipsters());
                    n1.setId(((Robot)factoryQueue.toArray()[i]).getId());
                    n1.setWeapon(((Robot)factoryQueue.toArray()[i]).getWeapon());

                    n2.setCanKillXHipsters(((Robot)factoryQueue.toArray()[j]).getCanKillXHipsters());
                    n2.setId(((Robot)factoryQueue.toArray()[j]).getId());
                    n2.setWeapon(((Robot)factoryQueue.toArray()[j]).getWeapon());

                    ((Robot)factoryQueue.toArray()[i]).setCanKillXHipsters(n2.getCanKillXHipsters());
                    ((Robot)factoryQueue.toArray()[i]).setId(n2.getId());
                    ((Robot)factoryQueue.toArray()[i]).setWeapon(n2.getWeapon());

                    ((Robot)factoryQueue.toArray()[j]).setCanKillXHipsters(n1.getCanKillXHipsters());
                    ((Robot)factoryQueue.toArray()[j]).setId(n1.getId());
                    ((Robot)factoryQueue.toArray()[j]).setWeapon(n1.getWeapon());
                }
            }
        }
    }*/
    @Override
    public void SortById(Queue<Robot> factory, int size) {
        if (size > 1) {
            for (int f = 0 ; f < size - 1 ; f++)
                if (((Robot)factory.toArray()[f]).getId() > ((Robot)factory.toArray()[f+1]).getId()) {
                    Robot n1 = new Robot();
                    Robot n2 = new Robot();
                    
                    n1.setCanKillXHipsters(((Robot)factoryQueue.toArray()[f]).getCanKillXHipsters());
                    n1.setId(((Robot)factoryQueue.toArray()[f]).getId());
                    n1.setWeapon(((Robot)factoryQueue.toArray()[f]).getWeapon());

                    n2.setCanKillXHipsters(((Robot)factoryQueue.toArray()[f+1]).getCanKillXHipsters());
                    n2.setId(((Robot)factoryQueue.toArray()[f+1]).getId());
                    n2.setWeapon(((Robot)factoryQueue.toArray()[f+1]).getWeapon());

                    ((Robot)factoryQueue.toArray()[f]).setCanKillXHipsters(n2.getCanKillXHipsters());
                    ((Robot)factoryQueue.toArray()[f]).setId(n2.getId());
                    ((Robot)factoryQueue.toArray()[f]).setWeapon(n2.getWeapon());

                    ((Robot)factoryQueue.toArray()[f+1]).setCanKillXHipsters(n1.getCanKillXHipsters());
                    ((Robot)factoryQueue.toArray()[f+1]).setId(n1.getId());
                    ((Robot)factoryQueue.toArray()[f+1]).setWeapon(n1.getWeapon());
                }
            SortById(factory, size - 1);
        }
    }
    
    
    public int buscarPorId(Queue<Robot> factory, int id, int size, int i)
    {
        if (i==size) 
            return -1;
        else if (((Robot)factory.toArray()[i]).getId()==id) 
                return i;
        else 
            return buscarPorId(factory, id, size, i+1);
    }
    
    public int sumCanKillXHipsters(Queue<Robot> factory, int size, int i, int sum)
    {
        if (size == i) 
            return sum;
        else 
            sum+= ((Robot)factory.toArray()[i]).getCanKillXHipsters();
            return sumCanKillXHipsters(factory, size, i+1, sum);
    }
    
    public boolean agregar(Queue<Robot> factory, int position, int i, Robot rb){
        if (position == i ){
            for (int j = factory.size()-1; j > position-1; j--) {
                factory.toArray()[j+1] = factory.toArray()[j];
                if (j == position-1){
                    factory.toArray()[j]= rb; 
                }
            }          
            return true;
        } else
            return agregar(factory, position, i+1, rb);        
    }
    
    
}
