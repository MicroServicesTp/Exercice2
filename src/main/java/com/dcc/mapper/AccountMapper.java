package com.dcc.mapper;

import com.dcc.dto.RequestAccountDto;
import com.dcc.dto.ResponseAccountDto;
import com.dcc.entities.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component

public class AccountMapper {

    public ResponseAccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }
        ResponseAccountDto dto = new ResponseAccountDto();
        BeanUtils.copyProperties(account, dto);
        return dto;

    }

    public Account toEntity(RequestAccountDto dto) {
        if (dto == null) {
            return null;
        }
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        return account;
    }
}
