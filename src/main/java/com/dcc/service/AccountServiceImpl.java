package com.dcc.service;

import com.dcc.dto.RequestAccountDto;
import com.dcc.dto.ResponseAccountDto;
import com.dcc.entities.Account;
import com.dcc.mapper.AccountMapper;
import com.dcc.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper ;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }


    @Override
    public ResponseAccountDto createAccount(RequestAccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        if (account.getSolde()==null){
            account.setSolde((double) 0);
        }
        return accountMapper.toDto(accountRepository.save(account));
    }

    @Override
    public List<ResponseAccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ResponseAccountDto updateAccount(long id, RequestAccountDto account) {
        Account oldAccount = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getSolde()!=null){oldAccount.setSolde((double) account.getSolde());}
        if (account.getNom()!=null){oldAccount.setNom(account.getNom());}
        if (account.getTel()!=null){oldAccount.setTel(account.getTel());}
        return  accountMapper.toDto(accountRepository.save(oldAccount));
    }

    @Override
    public void deleteAccount(long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        }else
            throw new RuntimeException("Account not found");
    }

    @Override
    public ResponseAccountDto getAccountById(long id) {
        return accountRepository.findById(id).map(accountMapper::toDto).orElse(null);
    }

    @Override
    public ResponseAccountDto addSolder(long id, long solde) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setSolde(account.getSolde()+ solde);
        return accountMapper.toDto(accountRepository.save(account));
    }

    @Override
    public ResponseAccountDto removeSolde(long id, long solde) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setSolde(account.getSolde()- solde);
        return accountMapper.toDto(accountRepository.save(account));    }
}
