@PutMapping("/{id}/availability")
public VolunteerProfile updateAvailability(
        @PathVariable Long id,
        @RequestParam String status) {

    return service.updateAvailability(id, status);
}
