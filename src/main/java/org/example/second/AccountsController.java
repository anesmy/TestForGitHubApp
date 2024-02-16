@GetMapping("/{clubId}/accounts")
public ResponseEntity<RawJson> getAccounts(@PathVariable Long clubId, @RequestParam String name) {
    String result = isNull(name)
                    ? economicService.getAccounts(clubId)
                    : economicService.getAccounts(clubId, name);

    return new ResponseEntity<>(RawJson.from(result), HttpStatus.OK);
}