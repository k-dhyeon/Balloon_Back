package com.balloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.balloon.entity.Chat;
import com.balloon.entity.Employee;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

	@Query(value = "select * " + "from chat " + "where chat_id in(select max(chat_id) " + "from chat "
			+ "group by chatroom_id ) " + "HAVING chatroom_id IN (select chatroom_id from chatroom_employee "
			+ "WHERE emp_id = :emp_id) order by chat_id desc; ", nativeQuery = true)
	public List<Chat> findAll(@Param("emp_id") Employee empId);

	public List<Chat> findAllByChatroomChatroomId(Long chatroomId);
}
