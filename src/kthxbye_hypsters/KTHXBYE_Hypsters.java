
package kthxbye_hypsters;

//import OurQueue.Noded.Queue;
import dao.FactoryDaoImp;
import dto.Robot;
import dto.Weapon;
import java.util.Scanner;

public class KTHXBYE_Hypsters {

    public static void main(String[] args) {
        
        //Queue fila = new Queue();
        Robot rb1 = new Robot();
        Robot rb2 = new Robot();
        Robot rb3 = new Robot();
        
        rb1.setId(1);
        rb1.setWeapon(Weapon.Katana);
        rb1.setCanKillXHipsters(50);        
        //fila.QueueUp(rb1);
        
        rb2.setId(2);
        rb2.setWeapon(Weapon.Kunai);
        rb2.setCanKillXHipsters(30);
        //fila.QueueUp(rb2);
        
        rb3.setId(3);
        rb3.setWeapon(Weapon.Shuriken);
        rb3.setCanKillXHipsters(25);
        //fila.QueueUp(rb3);
        
        
        FactoryDaoImp Factory = new FactoryDaoImp(); 
        Factory.Create(rb1);
        Factory.Create(rb2);
        Factory.Create(rb3);
        
        Scanner leer =new Scanner(System.in);
        int op = 0;
        
        boolean order = true;
        do {
            System.out.print("Opcion : ");
            op= leer.nextInt();
            
            switch(op){
                case 1:
                    for (int i = 0; i < Factory.factoryQueue.size(); i++) {
                        System.out.println("El "+(i+1)+"° robot en la fila tiene por arma: "+ ((Robot)Factory.factoryQueue.toArray()[i]).getWeapon());
                    }
                    break;
                case 2:
                    Factory.SortById(Factory.factoryQueue, Factory.factoryQueue.size());
                    /*if(order){
                        Factory.SortById(0);
                        order= false;
                    }else{
                        Factory.SortById(1);
                        order= true;                        
                    }*/
                    
                    for (int i = 0; i < Factory.GetAllData().size(); i++) {
                        System.out.println("El "+(i+1)+"° robot en la fila tiene por arma: "+ ((Robot)Factory.GetAllData().toArray()[i]).getWeapon());
                        System.out.println("El "+(i+1)+"° robot en la fila tiene el ID: "+ ((Robot)Factory.GetAllData().toArray()[i]).getId());
                    }
                    
                    break;
                case 3:
                    Factory.switchRobotId(1, 3);
                    
                    for (int i = 0; i < Factory.GetAllData().size(); i++) {
                        System.out.println("El "+(i+1)+"° robot en la fila tiene por arma: "+ ((Robot)Factory.GetAllData().toArray()[i]).getWeapon());
                        System.out.println("El "+(i+1)+"° robot en la fila tiene el ID: "+ ((Robot)Factory.GetAllData().toArray()[i]).getId());
                    }
                    break;
                case 4:
                    System.out.print("borrar por id: ");
                    int del = leer.nextInt();
                    Factory.DestroyById(del);
                    for (int i = 0; i < Factory.GetAllData().size(); i++) {
                        System.out.println("El "+(i+1)+"° robot en la fila tiene por arma: "+ ((Robot)Factory.GetAllData().toArray()[i]).getWeapon());
                        System.out.println("El "+(i+1)+"° robot en la fila tiene el ID: "+ ((Robot)Factory.GetAllData().toArray()[i]).getId());
                    }
                    break;
            }
           
        } while (op!=10);
        
        
    }
    
}
