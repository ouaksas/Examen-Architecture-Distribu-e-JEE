package org.sid.compteServ.Repositorys;

import org.sid.compteServ.Model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoOperation extends JpaRepository<Operation,Long> {
}
