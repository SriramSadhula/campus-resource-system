package com.ram.campusresourcesystem.controller;

import com.ram.campusresourcesystem.entity.Resource;
import com.ram.campusresourcesystem.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://hoppscotch.io"
})
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @PostMapping
    public Resource addResource(@RequestBody Resource resource) {
        return resourceService.addResource(resource);
    }
}