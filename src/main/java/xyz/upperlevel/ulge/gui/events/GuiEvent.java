package xyz.upperlevel.ulge.gui.events;

import lombok.Getter;
import lombok.NonNull;
import xyz.upperlevel.event.Event;
import xyz.upperlevel.ulge.gui.Gui;

public class GuiEvent implements Event {

    @Getter
    private Gui gui;

    public GuiEvent(@NonNull Gui gui) {
        this.gui = gui;
    }
}
