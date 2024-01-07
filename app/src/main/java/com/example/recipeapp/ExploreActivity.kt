package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.adapter.MainCategoryAdapter
import com.example.recipeapp.adapter.SubCategoryAdapter
import com.example.recipeapp.database.RecipeDatabase
import com.example.recipeapp.databinding.ActivityExploreBinding
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.Recipes

class ExploreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExploreBinding

    var arrMainCategory = ArrayList<Category>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      categories
        arrMainCategory.add(Category(1, "Breakfast"))
        arrMainCategory.add(Category(2, "Lunch"))
        arrMainCategory.add(Category(3, "Supper"))
        arrMainCategory.add(Category(4, "Snack"))

        mainCategoryAdapter.setData(arrMainCategory)

//      recipes
        arrSubCategory.add(Recipes(1,
            "Pesto Pasta with Cherry Tomatoes",
            "Dinner",
            "4",
            "beginner",
            "- 8 oz pasta\n" +
                    "- 1 cup fresh basil leaves\n" +
                    "- 1/2 cup grated Parmesan cheese\n" +
                    "- 1/3 cup pine nuts\n" +
                    "- 2 cloves garlic\n" +
                    "- 1/2 cup extra-virgin olive oil\n" +
                    "- Cherry tomatoes, halved",
            "1. Cook pasta according to package instructions.\n" +
                    "2. Blend basil, Parmesan, pine nuts, and garlic in a food processor.\n" +
                    "3. Gradually add olive oil while processing until smooth.\n" +
                    "4. Toss cooked pasta with pesto sauce and cherry tomatoes."
        ))
        arrSubCategory.add(Recipes(2,
            "Teriyaki Salmon",
            "Dinner",
            "5",
            "intermediate",
            "- 4 salmon fillets\n" +
                    "- 1/2 cup soy sauce\n" +
                    "- 1/4 cup mirin\n" +
                    "- 2 tablespoons brown sugar\n" +
                    "- 1 tablespoon grated ginger\n" +
                    "- 2 cloves garlic, minced",
            "1. Mix soy sauce, mirin, brown sugar, ginger, and garlic to make teriyaki sauce.\n" +
                    "2. Marinate salmon in the sauce for at least 30 minutes.\n" +
                    "3. Grill or bake salmon until cooked to your liking. Baste with teriyaki sauce while cooking."
        ))
        arrSubCategory.add(Recipes(3,
            "Mushroom Risotto",
            "Dinner",
            "2",
            "beginner",
            "- 1 cup Arborio rice\n" +
                    "- 4 cups chicken or vegetable broth, heated\n" +
                    "- 1 cup mushrooms, sliced\n" +
                    "- 1/2 cup dry white wine\n" +
                    "- 1 onion, finely chopped\n" +
                    "- 2 tablespoons butter\n" +
                    "- 1/2 cup grated Parmesan cheese",
            "1. Sauté onions in butter until translucent. Add mushrooms and cook until browned.\n" +
                    "2. Stir in Arborio rice and cook until lightly toasted.\n" +
                    "3. Pour in wine and cook until mostly absorbed.\n" +
                    "4. Gradually add hot broth, stirring constantly until rice is creamy.\n" +
                    "5. Stir in Parmesan cheese before serving."
        ))
        arrSubCategory.add(Recipes(4,
            "Chicken Caesar Salad",
            "Lunch",
            "4",
            "Beginner",
            "- 2 boneless, skinless chicken breasts\n" +
                    "- Romaine lettuce, chopped\n" +
                    "- Croutons\n" +
                    "- Grated Parmesan cheese\n" +
                    "- Caesar dressing",
            "1. Season chicken with salt and pepper, grill or pan-cook until done.\n" +
                    "2. Slice cooked chicken into strips.\n" +
                    "3. Toss lettuce with croutons, Parmesan, and chicken.\n" +
                    "4. Drizzle with Caesar dressing and serve."
        ))
        arrSubCategory.add(Recipes(5,
            "Stuffed Bell Peppers",
            "Dinner",
            "6",
            "Intermediate",
            "- 4 bell peppers, halved and cleaned\n" +
                    "- 1 lb ground beef or turkey\n" +
                    "- 1 cup cooked rice\n" +
                    "- 1 can black beans, drained and rinsed\n" +
                    "- 1 cup corn kernels\n" +
                    "- 1 cup tomato sauce",
            "1. Brown ground meat in a pan, then mix with cooked rice, black beans, corn, and tomato sauce.\n" +
                    "2. Stuff bell peppers with the mixture.\n" +
                    "3. Bake until peppers are tender."
        ))
        arrSubCategory.add(Recipes(6,
            "Greek Salad",
            "Breakfast",
            "2",
            "Beginner",
            "- 1 cucumber, diced\n" +
                    "- 4 tomatoes, diced\n" +
                    "- 1 red onion, thinly sliced\n" +
                    "- Kalamata olives\n" +
                    "- Feta cheese, crumbled\n" +
                    "- Olive oil\n" +
                    "- Red wine vinegar",
            "1. Combine cucumber, tomatoes, onion, olives, and feta in a bowl.\n" +
                    "2. Drizzle with olive oil and red wine vinegar.\n" +
                    "3. Toss gently and serve."
        ))
        arrSubCategory.add(Recipes(7,
            "Vegetable Stir-Fry",
            "Dinner",
            "4",
            "Beginner",
            "- 2 cups broccoli florets\n" +
                    "- 1 bell pepper, sliced\n" +
                    "- 1 carrot, julienned\n" +
                    "- 1 cup snap peas\n" +
                    "- 1 cup tofu or chicken, cubed\n" +
                    "- Soy sauce\n" +
                    "- Sesame oil",
            "1. Sauté tofu or chicken until cooked.\n" +
                    "2. Add vegetables and stir-fry until crisp-tender.\n" +
                    "3. Drizzle with soy sauce and a splash of sesame oil."
        ))
        arrSubCategory.add(Recipes(8,
            "Classic Margherita Pizza",
            "Snack",
            "6",
            "Intermediate",
            "- Pizza dough\n" +
                    "- Tomato sauce\n" +
                    "- Fresh mozzarella, sliced\n" +
                    "- Fresh basil leaves\n" +
                    "- Olive oil",
            "1. Roll out pizza dough and spread tomato sauce.\n" +
                    "2. Top with mozzarella slices and fresh basil.\n" +
                    "3. Drizzle with olive oil and bake until crust is golden.",
        ))
        arrSubCategory.add(Recipes(9,
            "Honey Mustard Glazed Salmon",
            "Dinner",
            "4",
            "Intermediate",
            "- 4 salmon fillets\n" +
                    "- 1/4 cup Dijon mustard\n" +
                    "- 2 tablespoons honey\n" +
                    "- 1 tablespoon soy sauce\n" +
                    "- Lemon wedges",
            "1. Mix mustard, honey, and soy sauce to create the glaze.\n" +
                    "2. Brush salmon with glaze and bake until cooked.\n" +
                    "3. Serve with lemon wedges."
        ))
        arrSubCategory.add(Recipes(10,
            "Crispy Baked Zucchini Fries",
            "Snack",
            "4",
            "Beginner",
            "- 2 zucchinis, cut into fries\n" +
                    "- 1 cup breadcrumbs\n" +
                    "- 1/2 cup grated Parmesan cheese\n" +
                    "- 2 eggs, beaten\n" +
                    "- Marinara sauce for dipping",
            "1. Preheat oven to 425°F (220°C).\n" +
                    "2. Dip zucchini fries in beaten eggs, then coat with a mixture of breadcrumbs and Parmesan.\n" +
                    "3. Place on a baking sheet and bake until golden and crispy.\n" +
                    "4. Serve with marinara sauce."
        ))

        subCategoryAdapter.setData(arrSubCategory)

        binding.recyclerMainCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerMainCategory.adapter = mainCategoryAdapter

        binding.recyclerSubCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        binding.recyclerSubCategory.adapter = subCategoryAdapter


    }
}