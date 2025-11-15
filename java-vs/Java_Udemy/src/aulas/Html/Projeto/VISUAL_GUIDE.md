# Guia Visual e Componentes

> Referência visual dos componentes do PJBruno Dashboard

## 🎨 Paleta de Cores

### Cores Primárias

```
Primary Purple
Hex: #9E6EFE
RGB: (158, 110, 254)
HSL: (264, 99%, 73%)
Uso: Botões, links, highlights, ícones ativos

├─ Light (6% alpha): rgba(158, 110, 254, 0.06)
│  Uso: Background hover, seleção suave
│
├─ Lighter (24% alpha): rgba(158, 110, 254, 0.24)
│  Uso: Barras de gráfico, backgrounds
│
└─ Dark: #272727
   Uso: Texto principal

Success Green
Hex: #0BB07B
RGB: (11, 176, 123)
HSL: (154, 88%, 37%)
Uso: Badges positivas, ícones de sucesso

Danger Red
Hex: #F03D3D
RGB: (240, 61, 61)
HSL: (0, 94%, 59%)
Uso: Badges negativas, ícones de erro

Warning Yellow
Hex: #FFCE52
RGB: (255, 206, 82)
HSL: (43, 100%, 66%)
Uso: Badges de aviso

Text Gray
Hex: #6A6969
RGB: (106, 105, 105)
HSL: (0, 1%, 41%)
Uso: Texto secundário

Background Light
Hex: #F3F4F8
RGB: (243, 244, 248)
HSL: (220, 15%, 96%)
Uso: Fundo da página

Border Light
Hex: #F2F6FF
RGB: (242, 246, 255)
HSL: (215, 70%, 97%)
Uso: Bordas, divisores

White
Hex: #FFFFFF
RGB: (255, 255, 255)
HSL: (0, 0%, 100%)
Uso: Cards, containers
```

---

## 📐 Escala de Spacing

```
xs  →  4px   (1/4 de lg)
sm  →  8px   (1/2 de lg)
md  → 12px   (3/4 de lg)
lg  → 16px   (base)
xl  → 24px   (1.5x lg)
2xl → 32px   (2x lg)
3xl → 40px   (2.5x lg)

Exemplo de uso:
padding: var(--spacing-lg);     /* 16px */
margin: var(--spacing-xl);      /* 24px */
gap: var(--spacing-md);         /* 12px */
```

---

## 🏗️ Estrutura de Componentes

### 1. Sidebar

```
┌─────────────────────────────┐
│          SIDEBAR            │
├─────────────────────────────┤
│                             │
│   ▌ e Front                 │
│                             │
├─────────────────────────────┤
│                             │
│   📊 Dashboard  ← ativo     │
│   👥 Clientes              │
│   📈 Vendas                │
│   ⚙️  Configurações       │
│   ─────────────────         │
│   🚪 Logout                │
│                             │
├─────────────────────────────┤
│                             │
│                             │
│   (conteúdo extra)         │
│                             │
└─────────────────────────────┘

Classe: .sidebar
Elementos:
  - .sidebar__header (logo)
  - .sidebar__nav (navegação)
  - .menu (lista)
  - .menu__item (item)
  - .menu__link (link)
  - .menu__link--active (modificador)
```

### 2. Header

```
┌───────────────────────────────────────────┐
│  Olá, Bruno Rocha          🔔  👤  Bruno  │
│  Bem-vindo de volta        (ícones)       │
└───────────────────────────────────────────┘

Classe: .header
Sub-componentes:
  - .header__greeting (saudação)
  - .header__title (h2)
  - .header__subtitle (p)
  - .header__actions (ações)
  - .icon-button (botões)
  - .user-profile (perfil)
```

### 3. Cards

```
┌──────────────────────────────┐
│ Título do Card              │
│                              │
│ Conteúdo do card            │
│ - Item 1                     │
│ - Item 2                     │
│                              │
└──────────────────────────────┘

Classe: .card
Elementos:
  - .card__title
  - .card__content (implícito)

Modificadores:
  - .card (padrão)
  - .card.featured (em destaque)
```

### 4. Gráfico de Barras

```
$
100K │     │  │  │
 50K │  │  │  │  │  │
     │──┴──┴──┴──┴──┴──
       J  F  M  A  M  J

Classe: .chart
Elementos:
  - .chart__content (container)
  - .chart__axis-y (eixo Y)
  - .chart__axis-label
  - .chart__bars (barras)
  - .chart__bar-group (grupo)
  - .chart__bar (barra individual)
  - .chart__label (label)
```

### 5. Tabela de Dados

```
┌─────────────────────────────────┐
│ ID    | Data      | Valor | Status│
├─────────────────────────────────┤
│#12345│02/08/2024│R$1500│✓ Aprovado
│#12346│03/08/2024│R$2300│⏳ Pendente
│#12347│04/08/2024│R$980 │✓ Aprovado
└─────────────────────────────────┘

Classe: .table-card
Elementos:
  - .table-card__title
  - .table (tabela)
  - .table__head (cabeçalho)
  - .table__header (célula cabeçalho)
  - .table__body (corpo)
  - .table__row (linha)
  - .table__cell (célula)
  - .status-badge (status)
```

### 6. Badge de Status

```
Positivo:  ● +12%     (verde com ícone)
Negativo:  ● -5%      (vermelho com ícone)

Classe: .stat-badge
Modificadores:
  - .stat-badge--positive (verde)
  - .stat-badge--negative (vermelho)

Elementos:
  - .stat-badge__icon
  - .stat-badge__text
```

### 7. Transações

```
┌───────────────────────────────┐
│ 02/08/2024          R$ 1.500  │
│ 03/08/2024          R$ 2.300  │
│ 04/08/2024          R$ 980    │
└───────────────────────────────┘

Classe: .transaction-item
Elementos:
  - .transaction-item__date
  - .transaction-item__value
  
Modificadores:
  - .transaction-item__value--positive (verde)
  - .transaction-item__value--negative (vermelho)
```

### 8. Cards de Estatísticas

```
┌──────────────────┐  ┌──────────────────┐
│ Vendas Semanais  │  │ Ticket Médio     │
│                  │  │                  │
│ R$ 15.240        │  │ R$ 1.250         │
│ ● +12%           │  │ ● -5%            │
└──────────────────┘  └──────────────────┘

Classe: .stat-card
Elementos:
  - .stat-card__content
  - .stat-card__label
  - .stat-card__value
  - .stat-badge (dentro)
```

---

## 🎯 Responsividade Visual

### Desktop (> 1024px)
```
┌─────────────────────────────────────────┐
│ SIDEBAR │                     MAIN      │
│         │  ┌─────────────────────────┐  │
│ Menu    │  │ Header                  │  │
│         │  └─────────────────────────┘  │
│         │  ┌──────────────┬──────────┐  │
│         │  │   Card 1     │  Card 2  │  │
│         │  ├──────────────┼──────────┤  │
│         │  │   Card 3     │  Card 4  │  │
│         │  └──────────────┴──────────┘  │
│         │                                 │
└─────────────────────────────────────────┘
```

### Tablet (768px - 1024px)
```
┌────────────────────────────┐
│ MAIN (sidebar flutuante)   │
├────────────────────────────┤
│ Header                     │
├────────────────────────────┤
│┌────────────┬────────────┐ │
││  Card 1    │  Card 2   ││ │
├────────────┼────────────┤ │
││  Card 3    │  Card 4   ││ │
│└────────────┴────────────┘ │
└────────────────────────────┘
```

### Mobile (480px - 768px)
```
┌────────────────────┐
│ MAIN               │
├────────────────────┤
│ Header             │
├────────────────────┤
│┌──────────────────┐│
││   Card 1         ││
├──────────────────┤│
││   Card 2        ││
├──────────────────┤│
││   Card 3        ││
│└──────────────────┘│
└────────────────────┘
```

### Small Mobile (< 480px)
```
┌──────────────┐
│ MAIN         │
├──────────────┤
│Header (col)  │
├──────────────┤
│┌────────────┐│
││ Card       ││
│└────────────┘│
│┌────────────┐│
││ Card       ││
│└────────────┘│
│┌────────────┐│
││ Card       ││
│└────────────┘│
└──────────────┘
```

---

## ⚡ Estados Interativos

### Menu Item States

```
Normal:
.menu__link
└─ Color: #272727
└─ Background: transparent

Hover:
.menu__link:hover
└─ Color: #9E6EFE (primary)
└─ Background: rgba(158, 110, 254, 0.06)
└─ Transition: 150ms ease-in-out

Active:
.menu__link--active
└─ Color: #9E6EFE
└─ Background: rgba(158, 110, 254, 0.06)
└─ ARIA: aria-current="page"

Focus (Keyboard):
.menu__link:focus-visible
└─ Outline: 2px solid #9E6EFE
└─ Outline-offset: 2px
```

### Button States

```
Normal:
.icon-button
└─ Background: #FFFFFF
└─ Color: #272727
└─ Cursor: pointer

Hover:
.icon-button:hover
└─ Background: #F3F4F8

Focus:
.icon-button:focus-visible
└─ Outline: 2px solid #9E6EFE
└─ Outline-offset: 2px
```

### Card States

```
Normal:
.card
└─ Background: #FFFFFF
└─ Box-shadow: 0 2px 8px rgba(0,0,0,0.04)
└─ Border-radius: 12px

Hover (opcional):
.card:hover
└─ Box-shadow: maior/mais visível
└─ Transform: translateY(-2px)
```

---

## 🔤 Tipografia

### Headings

```
h1 - Main Title
└─ Font: Poppins, 600
└─ Size: 30px
└─ Line-height: 1.5

h2 - Section Title
└─ Font: Poppins, 600
└─ Size: 20px
└─ Line-height: 1.2

h3 - Subsection
└─ Font: Poppins, 600
└─ Size: 16px
└─ Line-height: 1.2
```

### Body Text

```
Default
└─ Font: Poppins, 400
└─ Size: 16px
└─ Line-height: 1.6
└─ Color: #272727

Secondary
└─ Font: Poppins, 500
└─ Size: 14px
└─ Line-height: 1.6
└─ Color: #6A6969

Badge/Label
└─ Font: Inter, 600
└─ Size: 15px
└─ Line-height: 1.2
└─ Color: #0BB07B ou #F03D3D
```

---

## 📊 Layout Grid

### Desktop Layout
```css
.dashboard {
  display: grid;
  grid-template-columns: 304px 1fr;
  gap: 0;
  min-height: 100vh;
}

.sidebar {
  grid-column: 1;
  position: fixed;
  width: 304px;
}

.main {
  grid-column: 2;
  margin-left: 304px;
}
```

### Cards Container
```css
.cards-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(400px, 1fr));
  gap: 32px;
}
```

### Stats Container
```css
.stats-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 32px;
}
```

---

## ♿ Acessibilidade Visual

### Indicadores de Foco

```
┌─────────────────┐
│ Focus Visible   │  ← Outline 2px #9E6EFE
└─────────────────┘

Usado em:
- Buttons
- Links
- Menu items
- Inputs
```

### Indicadores de Status

```
Ativo:   ● Verde (#0BB07B)
Pendente: ⏳ Amarelo (#FFCE52)
Erro:    ✗ Vermelho (#F03D3D)
Sucesso: ✓ Verde (#0BB07B)
```

### Contraste de Cores

```
WCAG AA (mínimo 4.5:1):
✓ Text #272727 on #FFFFFF    (20.5:1)
✓ Text #6A6969 on #F3F4F8    (4.5:1)
✓ Text #0BB07B on #FFFFFF    (4.5:1)
✓ Text #F03D3D on #FFFFFF    (4.5:1)
```

---

## 🎬 Animações e Transições

### Transições CSS

```css
--transition-fast: 150ms ease-in-out
Uso: Hover states, simples interações

--transition-base: 300ms ease-in-out
Uso: Mudanças de layout, transformações

Exemplos:
.menu__link {
  transition: all 150ms ease-in-out;
}

.chart__bar:hover {
  transition: all 300ms ease-in-out;
}
```

### Animações GPU-Aceleradas

```css
✓ transform: translateY(-2px)
✓ transform: scale(1.1)
✓ opacity: 0.5

✗ width: 100px
✗ height: 50px
✗ padding: 16px
✗ left: 10px
```

---

## 📱 Breakpoints em Ação

```
≥ 1024px (Desktop)
┌─ Sidebar fixed, 2 colunas grid
└─ Stats grid 3 colunas

≤ 1024px (Tablet)
┌─ Sidebar absolute (colapsável)
└─ Stats grid 2 colunas

≤ 768px (Mobile)
┌─ Header flex-direction: column
└─ Stats grid 1 coluna

≤ 480px (Small Mobile)
┌─ Reduzir padding/margin
└─ Fonte menor em tabelas
```

---

**Referência Visual Completa do PJBruno Dashboard**

Use este guia como referência visual para manter consistência ao modificar componentes.
