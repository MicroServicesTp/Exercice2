package com.dcc.service;

import com.dcc.dto.RequestAccountDto;
import com.dcc.dto.ResponseAccountDto;

import java.util.List;

public interface AccountService {
    public ResponseAccountDto createAccount(RequestAccountDto accountDto);
    public List<ResponseAccountDto> getAllAccounts();
    public ResponseAccountDto updateAccount(long id , RequestAccountDto account);
    public void deleteAccount(long id);
    public ResponseAccountDto getAccountById(long id);
    public ResponseAccountDto addSolder(long id , long solde);
    public ResponseAccountDto removeSolde(long id , long solde);


}
