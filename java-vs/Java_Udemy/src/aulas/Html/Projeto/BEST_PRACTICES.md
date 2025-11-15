# Guia de Melhores Práticas - PJBruno Dashboard

> Padrões de desenvolvimento profissional aplicados neste projeto

## 📐 Arquitetura e Estrutura

### 1. Separação de Responsabilidades

**Princípio:** Cada arquivo tem uma responsabilidade clara

- **HTML (`PJBruno.html`)**
  - ✅ Estrutura semântica
  - ✅ Informação de conteúdo
  - ✅ Acessibilidade
  - ❌ Não contém estilos (inline style)
  - ❌ Não contém lógica

- **CSS (`PJBruno.css`)**
  - ✅ Apresentação visual
  - ✅ Layout e posicionamento
  - ✅ Responsividade
  - ❌ Não contém estrutura HTML
  - ❌ Não contém lógica de negócio

- **JavaScript (`PJBruno.js`)**
  - ✅ Interatividade
  - ✅ Lógica da aplicação
  - ✅ Gerenciamento de estado
  - ❌ Não contém estilos
  - ❌ Não manipula HTML estrutura

### 2. Padrão Module Pattern com Classes

```javascript
// Bom ✅
class Dashboard {
  constructor() {
    this.elements = {};
    this.init();
  }
  
  init() { /* ... */ }
  
  handleEvent(event) { /* ... */ }
}

// Evitar ❌
var dashboard = {
  init: function() { },
  handleEvent: function() { }
};

// Evitar ❌
function Dashboard() { }
Dashboard.prototype.init = function() { };
```

## 🎨 CSS - Boas Práticas

### 1. CSS Custom Properties (Design Tokens)

```css
/* Bom ✅ - Centralizado e reutilizável */
:root {
  --color-primary: #9E6EFE;
  --spacing-lg: 16px;
}

.card {
  color: var(--color-primary);
  padding: var(--spacing-lg);
}

/* Evitar ❌ - Valores hardcoded */
.card {
  color: #9E6EFE;
  padding: 16px;
}
```

### 2. Nomenclatura BEM (Block Element Modifier)

```css
/* Bom ✅ - Claro e previsível */
.menu { }                    /* Bloco */
.menu__item { }              /* Elemento */
.menu__item--active { }      /* Modificador */
.menu__item--disabled { }    /* Modificador */

/* Evitar ❌ - Ambíguo e frágil */
.menu { }
.item { }                    /* Qual é a relação? */
.active { }                  /* Classe genérica demais */
.menu.active .item { }       /* Acoplamento */
```

### 3. Mobile-First Responsive

```css
/* Bom ✅ - Mobile primeiro */
.card {
  padding: 16px;
  font-size: 14px;
}

@media (min-width: 768px) {
  .card {
    padding: 24px;
    font-size: 16px;
  }
}

/* Evitar ❌ - Desktop primeiro */
.card {
  padding: 40px;
  font-size: 18px;
}

@media (max-width: 768px) {
  .card {
    padding: 16px;
    font-size: 14px;
  }
}
```

### 4. Performance CSS

```css
/* Bom ✅ - GPU accelerated */
.chart__bar:hover {
  transform: scale(1.1);        /* GPU acelerado */
  transition: transform 0.15s;
}

/* Evitar ❌ - Força repaint */
.chart__bar:hover {
  width: 50px;                  /* Modifica layout */
  height: 200px;
  padding: 10px;
}
```

### 5. Cascata e Especificidade

```css
/* Bom ✅ - Especificidade baixa */
.menu__link {
  color: #272727;
}

.menu__link:hover {
  color: #9E6EFE;
}

/* Evitar ❌ - Especificidade alta */
nav ul li a.menu__link {
  color: #272727;
}

nav ul li a.menu__link:hover {
  color: #9E6EFE !important;
}
```

## 🏷️ HTML - Boas Práticas

### 1. Semantic Markup

```html
<!-- Bom ✅ - Semântico -->
<header>
  <nav role="navigation" aria-label="Menu principal">
    <ul>
      <li><a href="/">Home</a></li>
    </ul>
  </nav>
</header>

<main role="main">
  <article>
    <h2>Título do Artigo</h2>
    <p>Conteúdo...</p>
  </article>
</main>

<!-- Evitar ❌ - Divs demais -->
<div class="header">
  <div class="nav">
    <div class="menu">
      <div class="menu-item"><a href="/">Home</a></div>
    </div>
  </div>
</div>

<div class="main">
  <div class="article">
    <div class="title">Título</div>
    <div class="content">Conteúdo...</div>
  </div>
</div>
```

### 2. Acessibilidade (ARIA)

```html
<!-- Bom ✅ - Acessível -->
<button aria-label="Menu" aria-haspopup="true" aria-expanded="false">
  ☰
</button>

<section aria-labelledby="charts-title">
  <h2 id="charts-title">Gráficos</h2>
  <!-- conteúdo -->
</section>

<time datetime="2024-08-02">02 de Agosto</time>

<!-- Evitar ❌ - Sem contexto para leitores de tela -->
<button>☰</button>

<div id="charts">
  <div>Gráficos</div>
  <!-- conteúdo -->
</div>

<div>02/08/2024</div>
```

### 3. Atributos Alt em Imagens

```html
<!-- Bom ✅ -->
<img src="user.jpg" alt="Foto de perfil do usuário João Silva">

<!-- Evitar ❌ -->
<img src="user.jpg" alt="image">
<img src="user.jpg" alt="">  <!-- Se apenas decorativa -->
```

### 4. Estrutura de Headings

```html
<!-- Bom ✅ - Hierarquicamente correto -->
<h1>Dashboard eFront</h1>
  <h2>Seção Gráficos</h2>
    <h3>Vendas Semanais</h3>
  <h2>Seção Transações</h2>

<!-- Evitar ❌ - Hierarquia quebrada -->
<h1>Dashboard</h1>
<h3>Gráficos</h3>      <!-- Pula h2 -->
<h2>Transações</h2>
<h4>Detalhes</h4>      <!-- Pula h3 -->
```

## 🛠️ JavaScript - Boas Práticas

### 1. Uso de Constantes e Let

```javascript
/* Bom ✅ */
const DEBOUNCE_DELAY = 300;
let menuState = 'closed';

const setupMenu = () => {
  const items = document.querySelectorAll('.menu__item');
  items.forEach(item => {
    item.addEventListener('click', handleMenuClick);
  });
};

/* Evitar ❌ */
var DEBOUNCE_DELAY = 300;
var menuState = 'closed';

var setupMenu = function() {
  var items = document.querySelectorAll('.menu__item');
  for (var i = 0; i < items.length; i++) {
    items[i].addEventListener('click', function(e) { /* ... */ });
  }
};
```

### 2. Métodos de Array Modernos

```javascript
/* Bom ✅ */
const activeItems = items
  .filter(item => item.classList.contains('active'))
  .map(item => item.textContent);

const total = numbers.reduce((sum, num) => sum + num, 0);

items.forEach(item => item.addEventListener('click', handler));

/* Evitar ❌ */
var activeItems = [];
for (var i = 0; i < items.length; i++) {
  if (items[i].className.indexOf('active') > -1) {
    activeItems.push(items[i].textContent);
  }
}

var total = 0;
for (var i = 0; i < numbers.length; i++) {
  total += numbers[i];
}
```

### 3. Event Delegation

```javascript
/* Bom ✅ - Um listener, múltiplos elementos */
container.addEventListener('click', (e) => {
  if (e.target.classList.contains('menu__link')) {
    handleMenuClick(e);
  }
});

/* Evitar ❌ - Listener em cada elemento */
const items = document.querySelectorAll('.menu__link');
items.forEach(item => {
  item.addEventListener('click', handleMenuClick);
});
```

### 4. Debounce para Performance

```javascript
/* Bom ✅ */
const handleResize = debounce(() => {
  setupResponsiveSidebar();
}, 300);

window.addEventListener('resize', handleResize);

/* Evitar ❌ - Executa a cada pixel */
window.addEventListener('resize', () => {
  setupResponsiveSidebar();
});
```

### 5. Documentação com JSDoc

```javascript
/* Bom ✅ */
/**
 * Formata um valor monetário
 * @param {number} value - Valor a formatar
 * @param {string} currency - Código da moeda (default: 'BRL')
 * @returns {string} Valor formatado com símbolo de moeda
 * @example
 * formatCurrency(1500, 'BRL') // "R$ 1.500,00"
 */
function formatCurrency(value, currency = 'BRL') {
  // implementação
}

/* Evitar ❌ */
function formatCurrency(value, currency) {
  // implementação
}
```

## 🔒 Segurança

### 1. Validação de Entrada

```javascript
/* Bom ✅ */
function updateUserName(name) {
  // Validar tipo
  if (typeof name !== 'string') {
    throw new TypeError('Name must be a string');
  }
  
  // Validar comprimento
  if (name.length < 3 || name.length > 100) {
    throw new Error('Name must be between 3 and 100 characters');
  }
  
  // Sanitizar
  const sanitized = name.trim();
  
  // Usar
  document.querySelector('.user-name').textContent = sanitized;
}

/* Evitar ❌ */
function updateUserName(name) {
  document.querySelector('.user-name').innerHTML = name; // XSS!
}
```

### 2. Proteção contra XSS

```javascript
/* Bom ✅ - Usar textContent */
element.textContent = userInput;

/* Evitar ❌ - Usar innerHTML com entrada do usuário */
element.innerHTML = userInput; // Risco de XSS
```

## 📊 Performance

### 1. Cache de Elementos DOM

```javascript
/* Bom ✅ - Cache */
class Dashboard {
  constructor() {
    this.menu = document.querySelector('.menu');
    this.items = this.menu.querySelectorAll('.menu__item');
  }
  
  handleClick(item) {
    // Usa cached elements
  }
}

/* Evitar ❌ - Query a cada vez */
class Dashboard {
  handleClick(item) {
    const menu = document.querySelector('.menu');
    const items = menu.querySelectorAll('.menu__item');
    // ...
  }
}
```

### 2. Event Delegation

```javascript
/* Bom ✅ - 1 listener */
container.addEventListener('click', (e) => {
  if (e.target.matches('.item')) {
    handleItemClick(e);
  }
});

/* Evitar ❌ - N listeners */
items.forEach(item => {
  item.addEventListener('click', handleItemClick);
});
```

## 🧪 Testabilidade

### 1. Funções Puras

```javascript
/* Bom ✅ - Fácil de testar */
function calculateTotal(items) {
  return items.reduce((sum, item) => sum + item.price, 0);
}

test('calculateTotal', () => {
  expect(calculateTotal([{ price: 10 }])).toBe(10);
});

/* Evitar ❌ - Efeitos colaterais */
let total = 0;
function addToTotal(item) {
  total += item.price;
  document.querySelector('.total').textContent = total;
}
```

## 📋 Checklist de Qualidade

Antes de considerar o código "pronto":

- [ ] **HTML válido** - Passa validação W3C
- [ ] **Semântico** - Usa tags apropriadas
- [ ] **Acessível** - Testado com leitores de tela
- [ ] **Responsivo** - Funciona em todos os tamanhos
- [ ] **CSS organizado** - Segue BEM, sem conflitos
- [ ] **Performance** - Sem memleaks ou repaints
- [ ] **Segurança** - Sem XSS, SQL injection
- [ ] **Documentado** - Comentários e README
- [ ] **Testado** - Funciona nos navegadores alvo
- [ ] **Atualizável** - Código limpo e reutilizável

## 🚀 Próximos Passos

1. Implementar testes automatizados
2. Adicionar build process (Webpack, Vite)
3. Setup de CI/CD (GitHub Actions)
4. Implementar service workers (PWA)
5. Adicionar hot reload em desenvolvimento

---

**Lembre-se:** "Código limpo é código que você gostaria de ler."
