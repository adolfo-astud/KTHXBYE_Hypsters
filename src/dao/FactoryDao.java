/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import OurQueue.Noded.Queue;

import dto.Robot;
import java.util.Queue;



/**
 *
 * @author Serph
 */
public interface FactoryDao extends BaseDao {
    
    public Queue<Robot> GetAllData();
    //public void SortById(int order);
    public void SortById(Queue<Robot> factory, int size);
    public void switchRobotId(int rb1, int rb2);
    public boolean DestroyById(int id);
    
    
}
