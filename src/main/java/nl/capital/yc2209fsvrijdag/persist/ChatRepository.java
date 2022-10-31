package nl.capital.yc2209fsvrijdag.persist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.capital.yc2209fsvrijdag.domein.Chat;

@Component
public interface ChatRepository extends CrudRepository<Chat, Long>{

}
