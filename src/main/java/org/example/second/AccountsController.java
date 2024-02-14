package org.example.second;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.Objects.isNull;

public class AccountsController {
    @GetMapping("/{clubId}/accounts")
    public ResponseEntity<RawJson> getAccounts(@PathVariable Long clubId, @RequestParam String name) {
        String result = isNull(name)
                ? economicService.getAccounts(clubId)
                : economicService.getAccounts(clubId, name);

        return new ResponseEntity<>(RawJson.from(result), HttpStatus.OK);
    }
}
