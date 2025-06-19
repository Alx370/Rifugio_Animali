package com.catarsi.Rifugio_Animali.services;


import com.catarsi.Rifugio_Animali.model.Admin;

import java.util.List;

public interface RifugioServiceAdmin {

    Admin addAdmin(Admin a);
    List<Admin> getAllAdmin();
}
