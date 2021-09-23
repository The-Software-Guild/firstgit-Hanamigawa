/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma;

import com.ztq.venma.controller.VenMaController;
import com.ztq.venma.dao.VenMaAuditDao;
import com.ztq.venma.dao.VenMaAuditDaoFileImpl;
import com.ztq.venma.dao.VenMaDao;
import com.ztq.venma.dao.VenMaDaoIOException;
import com.ztq.venma.dao.VenMaDaoFileImpl;
import com.ztq.venma.service.VenMaService;
import com.ztq.venma.ui.UserIO;
import com.ztq.venma.ui.UserIOConsoleImpl;
import com.ztq.venma.ui.VenMaView;

/**
 *
 * @author tianqi.zhu
 */
public class App {
    
    public static void main(String[] args) throws VenMaDaoIOException {
        UserIO io = new UserIOConsoleImpl();
        VenMaView view = new VenMaView(io);
        
        VenMaDao dao;
        VenMaAuditDao auditDao;
        try {   // initialize dao and auditDao, because they must be initialized from file, so try-catch
            dao = new VenMaDaoFileImpl();
            auditDao = new VenMaAuditDaoFileImpl();
        } catch (VenMaDaoIOException e) {
            System.out.println(e.getMessage());
            return;
        }
        VenMaService service = new VenMaService(dao, auditDao);
        VenMaController controller = new VenMaController(service, view);
        controller.run();
        dao.save(); // save the dao back to file
    }
    
    
    
    
    
}
