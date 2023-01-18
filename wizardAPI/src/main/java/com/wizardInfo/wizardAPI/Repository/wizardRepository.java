package com.wizardInfo.wizardAPI.Repository;

import com.wizardInfo.wizardAPI.Entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface wizardRepository extends JpaRepository<Wizard, Long> {

}
