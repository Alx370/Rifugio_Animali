package com.catarsi.Rifugio_Animali.services;

import com.catarsi.Rifugio_Animali.model.Admin;
import com.catarsi.Rifugio_Animali.repos.RifugioRepoAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifugioServiceAdminImpl implements RifugioServiceAdmin{

    @Autowired
    private RifugioRepoAdmin admin_repo;

    @Override
    public Admin addAdmin(Admin a) {
        return admin_repo.save(a);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return admin_repo.findAll();
    }
}
