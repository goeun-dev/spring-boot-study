package org.go.day2.repositories;

import org.go.day2.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BoardRepository
 */
public interface BoardRepository extends JpaRepository<Board, Integer>{

    // keyword search, Containing - parameter bound wrapped in %
    public Page<Board> findByTitleContaining(String keyword, Pageable page);
}