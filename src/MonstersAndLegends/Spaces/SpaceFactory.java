package MonstersAndLegends.Spaces;

import Games.BoardGames.Cell;

import java.io.FileNotFoundException;

// Factory class that produce 3 different types of space
public class SpaceFactory {
    public Space create_space(String type) throws FileNotFoundException {
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case "Market":
                return new MarketSpace(type);
            case "Inaccessible":
                return new InaccessibleSpace(type);
            case "Common":
                return new CommonSpace(type);
            default:
                throw new IllegalArgumentException("Unknown type "+ type);
        }
    }
}
