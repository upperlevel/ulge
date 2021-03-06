package xyz.upperlevel.ulge.gui.events;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import xyz.upperlevel.ulge.gui.Gui;

public class GuiDragEvent extends GuiEvent {

    @Getter
    @Setter
    private double startX, startY, endX, endY;

    public GuiDragEvent(@NonNull Gui gui, double startX, double startY, double endX, double endY) {
        super(gui);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
