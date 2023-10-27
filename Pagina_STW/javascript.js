const recipes = [];
let fieldCount = 0;

const recipeForm = document.getElementById("recipeForm");
const addIngredientButton = document.getElementById("addIngredient");
const removeIngredientButton = document.getElementById("removeIngredient");
const ingredients = document.getElementById("ingredients");
const recipeNameField = document.getElementById("recipeName");
const recipesList = document.getElementById("recipesList");

const ingredientElements = () => `
    <div class="ingredient">
        <div class="formField">
            <label for="ingredient${fieldCount}">Digite o nome do ingrediente</label>
            <input id="ingredient${fieldCount}" class="ingredientName" type="text" />
        </div>
        <div class="formField">
            <label for="quantity${fieldCount}">Digite a quantidade</label>
            <input id="quantity${fieldCount}" class="ingredientQuantity" type="text" />
        </div>
    </div>
`;

addIngredientButton.addEventListener("click", () => {
  fieldCount++;
  ingredients.innerHTML = ingredients.innerHTML + ingredientElements();
});

removeIngredientButton.addEventListener("click", () => {
  const ingredientFields = document.querySelectorAll("div.ingredient");
  if (ingredientFields.length > 1)
    ingredientFields[ingredientFields.length - 1].remove();
});

recipeForm.addEventListener("submit", (e) => {
  e.preventDefault();

  hasEmptyField = false;
  const recipe = {
    name: recipeNameField.value,
    ingredients: [],
  };
  const ingredientNameFields = document.querySelectorAll(
    "input.ingredientName"
  );
  const ingredientQuantityFields = document.querySelectorAll(
    "input.ingredientQuantity"
  );
  const inputFields = document.querySelectorAll("input");

  inputFields.forEach((input) => {
    if (input.value === "") hasEmptyField = true;
  });
  if (hasEmptyField) return alert("Por favor preencha todos os campos.");

  ingredientNameFields.forEach((ingredientName, index) => {
    recipe.ingredients.push({});
    recipe.ingredients[index].name = ingredientName.value;
  });

  ingredientQuantityFields.forEach((ingredientQuantity, index) => {
    recipe.ingredients[index].quantity = ingredientQuantity.value;
  });

  recipes.push(recipe);
  showRecipes();
  resetForm();
});

const showRecipes = () => {
  if (!recipes.length) return;
  let recipeElement = "<li>";

  recipes.forEach((recipe) => {
    recipeElement += `<h3>${recipe.name}</h3>`;
    recipe.ingredients.forEach((ingredient) => {
      recipeElement += `
      <div>
        <span>${ingredient.name}</span>
        <span>${ingredient.quantity}</span>
      </div>  
    `;
    });
  });

  recipeElement += "</li>";
  recipesList.innerHTML = recipesList.innerHTML + recipeElement;
};

const resetForm = () =>
  (recipeForm.innerHTML = `
    <div class="formField">
      <label for="recipeName">Nome da receita</label>
      <input id="recipeName" type="text" />
    </div>
    <div class="ingredientsButtons">
      <button type="button" id="addIngredient">+</ type="button">
      <button type="button" id="removeIngredient">-</button>
    </div>
    <div id="ingredients">
      <div class="ingredient">
        <div class="formField">
          <label for="ingredient0">Digite o nome do ingrediente</label>
          <input id="ingredient0" class="ingredientName" type="text" />
        </div>
        <div class="formField">
          <label for="quantity0">Digite a quantidade</label>
          <input id="quantity0" class="ingredientQuantity" type="text" />
        </div>
      </div>
    </div>
    <button type="submit">Salvar Receita</button>
  `);

showRecipes();
