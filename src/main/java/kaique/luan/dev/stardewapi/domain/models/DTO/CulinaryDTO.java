package kaique.luan.dev.stardewapi.domain.models.DTO;

import java.util.List;

public class CulinaryDTO {
    private String itemId;
    private List<IngredientDTO> ingredients;
    private int energy;
    private int health;
    private List<BonusDTO> bonuses;
    private String font;
    private int price;

    public static class IngredientDTO {
        private String itemId;
        private int quantity;

        public String getItemId() { return itemId; }
        public void setItemId(String itemId) { this.itemId = itemId; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }

    public static class BonusDTO {
        private int level;
        private String duration;

        public int getLevel() { return level; }
        public void setLevel(int level) { this.level = level; }

        public String getDuration() { return duration; }
        public void setDuration(String duration) { this.duration = duration; }
    }

    public List<BonusDTO> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<BonusDTO> bonuses) {
        this.bonuses = bonuses;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
