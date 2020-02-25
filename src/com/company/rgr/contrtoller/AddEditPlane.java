package com.company.rgr.contrtoller;

import com.company.rgr.utils.Logger;

public class AddEditPlane {

    Logger logger = Logger.getLogger(this.getClass());

    // Делегат для добавления самолета
    Controller parent;

    public void mouseClicked(){
        logger.log("Tag", "Message");
        parent.test();
    }
}
