/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ztq.venma.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author tianqi.zhu
 */
public class VenMaAuditDaoFileImpl implements VenMaAuditDao{
    
    public String AUDIT_FILE = "audit.txt";

    public VenMaAuditDaoFileImpl() {
    }

    // for test use
    public VenMaAuditDaoFileImpl(String testAuditFile) {
        AUDIT_FILE = testAuditFile;
    }
    
    @Override
    public void writeAuditEnty(String entry) {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
            LocalDateTime timestamp = LocalDateTime.now();
            out.println(timestamp.toString() + " : " + entry);
            out.flush();
        } catch (IOException e) {
            System.out.print("Could not open audit file");
        }
    }

}
