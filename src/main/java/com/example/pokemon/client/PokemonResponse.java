package com.example.pokemon.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonResponse {
    private String name;
    private List<Ability> abilities;
    private Sprites sprites;



    public static class Ability {
        private AbilityInfo ability;

        public AbilityInfo getAbility() {
            return ability;
        }

        public void setAbility(AbilityInfo ability) {
            this.ability = ability;
        }

        public static class AbilityInfo {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class Sprites {
        private String front_default;

        public String getFront_default() {
            return front_default;
        }

        public void setFront_default(String front_default) {
            this.front_default = front_default;
        }
    }
}