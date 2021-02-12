package org.sid.compteServ.Repositorys;

import org.sid.compteServ.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCompte extends JpaRepository<Compte,Long> {
}
