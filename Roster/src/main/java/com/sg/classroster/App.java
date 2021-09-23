/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.service.ClassRosterServiceLayerImpl;
import com.sg.classroster.service.ServiceLayer;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author zwhet
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        
        ServiceLayer service = new ClassRosterServiceLayerImpl(dao);
        
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterController controller = new ClassRosterController(view, service);
        controller.run();
    }
}
