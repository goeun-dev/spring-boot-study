package org.go.day1_2.repositories;

import org.go.day1_2.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * MemberRepository
 * PagingAndSortingRepository: CrudRepository를 상속받는 인터페이스. 페이징 처리 관련 메소드 제공.
 */
public interface MemberRepository extends PagingAndSortingRepository<Member, String> {

    
}