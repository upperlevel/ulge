package xyz.upperlevel.ulge.gui;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import xyz.upperlevel.ulge.events.EventManager;
import xyz.upperlevel.ulge.events.impl.SimpleEventManager;

public class BaseGui implements Gui {

    @Getter
    @Setter
    @NonNull
    private Bounds bounds;

    @Getter
    @Setter
    @NonNull
    private EventManager eventManager;

    public BaseGui(Bounds bounds, EventManager eventManager) {
        this.bounds = bounds;
        this.eventManager = eventManager;
    }

    public BaseGui(Bounds bounds) {
        this(bounds, new SimpleEventManager());
    }

    public BaseGui() {
        this(Bounds.FULL, new SimpleEventManager());
    }

    @Override
    public void init(GuiRenderer r) {
    }

    @Override
    public void draw(GuiRenderer r) {
        r.getTexture().bind();
        r.setBounds(bounds);
        r.fill();
    }
}
