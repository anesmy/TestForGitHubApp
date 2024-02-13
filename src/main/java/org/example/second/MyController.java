package org.example.second;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class MyController {
    EconomicService economicService;

    @GetMapping("/{clubId}/accounts")
    public ResponseEntity<RawJson> getAccounts(@PathVariable Long clubId, @RequestParam String name) {
        String result = isNull(name)
                ? economicService.getAccounts(clubId)
                : economicService.getAccounts(clubId, name);

        return new ResponseEntity<>(RawJson.from(result), HttpStatus.OK);
    }
}
