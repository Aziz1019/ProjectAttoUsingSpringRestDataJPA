package inc.star.attoproject.controller;

import inc.star.attoproject.dto.StationDto;
import inc.star.attoproject.model.ResMessage;
import inc.star.attoproject.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/station")

public class StationController {
    private final StationService stationService;

    @PostMapping
    public ResMessage saveStation(@RequestBody StationDto stationDto){
        return stationService.save(stationDto);
    }

    @GetMapping
    public ResMessage getAllStation(){
        return stationService.getAllStation();
    }

    @GetMapping("{stationId}")
    public ResMessage getStationById(@PathVariable Integer stationId){
        return stationService.getStationById(stationId);
    }

}
