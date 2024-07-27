package br.com.alelvis3.sysAlelvisTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alelvis3.sysAlelvisTec.model.ClientePF;

@Repository
public interface ClientePFRepository extends JpaRepository<ClientePF, Long> {
}