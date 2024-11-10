package com.kevin.gestionhistoriaclinica.services.user;

import com.kevin.gestionhistoriaclinica.models.dto.user.UserDto;
import com.kevin.gestionhistoriaclinica.models.entities.user.Role;
import com.kevin.gestionhistoriaclinica.models.entities.user.User;

public interface IUserService {
    User findById(Long id);

    User save(UserDto dto);

    User save(UserDto dto, Role role);

    User update(Long id, UserDto dto);

    Boolean delete(Long id);
}
