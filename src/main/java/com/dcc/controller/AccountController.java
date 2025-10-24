package com.dcc.controller;


import com.dcc.dto.RequestAccountDto;
import com.dcc.dto.ResponseAccountDto;
import com.dcc.entities.Account;
import com.dcc.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<ResponseAccountDto> createAccount(@RequestBody RequestAccountDto accountDto) {
        ResponseAccountDto created = accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseAccountDto> updateAccount(@PathVariable long id,@RequestBody RequestAccountDto accountDto) {
        return ResponseEntity.ok(accountService.updateAccount(id , accountDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseAccountDto> getAccountById(@PathVariable long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponseAccountDto>> getAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/add/{solde}")
    public ResponseEntity<ResponseAccountDto> addSolde(@PathVariable long id, @PathVariable long solde) {
        return ResponseEntity.ok(accountService.addSolder(id,solde));
    }

    @PatchMapping("{id}/remove/{solde}")
    public ResponseEntity<ResponseAccountDto> removeSolde(@PathVariable long id, @PathVariable long solde) {
        return ResponseEntity.ok(accountService.removeSolde(id,solde));
    }
}
