package com.switchfully.eurder.Eurder.domain;

import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EurderRepository extends JpaRepository<Eurder, UUID> {
}
