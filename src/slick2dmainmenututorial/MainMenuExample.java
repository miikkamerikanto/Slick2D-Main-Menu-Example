package slick2dmainmenututorial;

import java.awt.Font;
import org.newdawn.slick.*;

public class MainMenuExample extends BasicGame {

    private Font font;
    private TrueTypeFont ttf;
    private String[] playersOptions = new String[3];
    private int playersChoice = 0;
    private Color notChosen = new Color(153, 204, 255);
    private static final int NOCHOICES = 3;
    private boolean exit = false;

    public MainMenuExample() {
        super("Slick2D Main Menu Example");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        font = new Font("Verdana", Font.BOLD, 40);
        ttf = new TrueTypeFont(font, true);
        playersOptions[0] = "Start";
        playersOptions[1] = "Options";
        playersOptions[2] = "Quit";
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_DOWN)) {
            if (playersChoice == (NOCHOICES - 1)) {
                playersChoice = 0;
            } else {
                playersChoice++;
            }
        }
        if (input.isKeyPressed(Input.KEY_UP)) {
            if (playersChoice == 0) {
                playersChoice = NOCHOICES - 1;
            } else {
                playersChoice--;
            }
        }
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            switch (playersChoice) {
                case 2:
                    exit = true;
                    break;
            }
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        renderPlayersOptions();
        if (exit) {
            gc.exit();
        }
    }

    public static void main(String[] args)
            throws SlickException {
        AppGameContainer app =
                new AppGameContainer(new MainMenuExample());
        app.setDisplayMode(800, 600, true);
        app.start();
    }

    private void renderPlayersOptions() {
        for (int i = 0; i < 3; i++) {
            if (playersChoice == i) {
                ttf.drawString(100, i * 50 + 200, playersOptions[i]);
            } else {
                ttf.drawString(100, i * 50 + 200, playersOptions[i], notChosen);
            }
        }
    }
}
