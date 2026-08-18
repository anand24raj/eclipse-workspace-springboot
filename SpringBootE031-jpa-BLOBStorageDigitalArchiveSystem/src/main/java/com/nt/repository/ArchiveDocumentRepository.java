package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.ArchiveDocument;

public interface ArchiveDocumentRepository extends JpaRepository<ArchiveDocument, Long> {

}
