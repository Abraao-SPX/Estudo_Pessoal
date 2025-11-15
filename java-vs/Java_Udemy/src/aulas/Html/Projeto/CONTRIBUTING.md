# Guia de Desenvolvimento e Contribuição

> Instruções para trabalhar com o PJBruno Dashboard

## 🚀 Começando

### Pré-requisitos
- Navegador moderno (Chrome, Firefox, Safari, Edge)
- Editor de código (VS Code recomendado)
- Conhecimento de HTML5, CSS3, JavaScript ES6+

### Setup Inicial
1. Clone ou baixe o projeto
2. Abra `PJBruno.html` em um navegador
3. Abra os arquivos em seu editor
4. Pronto para trabalhar!

## 📝 Estrutura de Arquivos

```
PJBruno/
├── PJBruno.html          # Markup (644 linhas)
│   ├── DOCTYPE e meta tags
│   ├── Sidebar com menu
│   ├── Main content
│   └── Scripts
│
├── PJBruno.css           # Estilos (650+ linhas)
│   ├── Design System (variables)
│   ├── Reset e base styles
│   ├── Componentes (BEM)
│   ├── Responsive breakpoints
│   └── Accessibility (media queries)
│
├── PJBruno.js            # Lógica (350+ linhas)
│   ├── Dashboard class
│   ├── DashboardUtils class
│   ├── DashboardAnalytics class
│   └── Inicialização
│
├── README.md             # Documentação técnica
├── BEST_PRACTICES.md     # Padrões de código
├── SUMMARY.md            # Resumo da refatoração
└── CONTRIBUTING.md       # Este arquivo
```

## 🔧 Adicionando Componentes

### Novo Componente CSS

1. **Defina as variáveis** (se necessário)
```css
:root {
  --component-color: #123456;
  --component-size: 20px;
}
```

2. **Crie a classe BEM**
```css
.component {
  color: var(--component-color);
  padding: var(--component-size);
}

.component__element {
  /* Elemento dentro do componente */
}

.component--modifier {
  /* Variação do componente */
}
```

3. **Adicione responsive se necessário**
```css
@media (max-width: 768px) {
  .component {
    padding: var(--spacing-lg);
  }
}
```

### Novo Elemento HTML

1. **Use elementos semânticos**
```html
<article class="component">
  <h3 class="component__title">Título</h3>
  <p class="component__content">Conteúdo</p>
</article>
```

2. **Adicione ARIA labels se interativo**
```html
<button 
  class="component__button"
  aria-label="Descrição para leitores de tela"
  aria-haspopup="true"
>
  Ação
</button>
```

### Nova Funcionalidade JavaScript

1. **Crie o método na classe apropriada**
```javascript
class Dashboard {
  handleNewEvent(event) {
    // Validar evento
    if (!event.target) return;
    
    // Implementar lógica
    this.updateComponent(event.target);
    
    // Rastrear
    DashboardAnalytics.trackUserAction('new_event');
  }
}
```

2. **Adicione o event listener**
```javascript
constructor() {
  this.newElement = document.querySelector('.new-element');
  this.newElement.addEventListener('click', (e) => this.handleNewEvent(e));
}
```

3. **Documente com JSDoc**
```javascript
/**
 * Descrição do que o método faz
 * @param {Event} event - O evento disparado
 * @throws {Error} Descrição do erro possível
 */
handleNewEvent(event) {
  // implementação
}
```

## 🎨 Modificando Estilos

### Mudança de Cor

**Opção 1: Modificar variável (recomendado)**
```css
:root {
  --color-primary: #NEW_COLOR;
}
```
Afeta TUDO que usa a cor primária.

**Opção 2: Modificador BEM**
```css
.button--secondary {
  background-color: var(--color-secondary);
}
```

### Adicionar Responsividade

1. **Adicionar novo breakpoint** (se necessário)
```css
@media (max-width: 1200px) {
  /* Estilos para telas <= 1200px */
}
```

2. **Testar em todos os breakpoints:**
   - Desktop: > 1024px
   - Tablet: 768px - 1024px
   - Mobile: 480px - 768px
   - Small: < 480px

### Performance

- ✅ Use `transform` e `opacity` para animações
- ✅ Evite mudar `width`, `height`, `padding`, `margin` em hover
- ✅ Use `will-change` com moderação
- ❌ Evite `box-shadow` em hover

```css
/* Bom ✅ */
.card:hover {
  transform: translateY(-2px);
}

/* Ruim ❌ */
.card:hover {
  box-shadow: 0 20px 40px rgba(0,0,0,0.1);
  padding: 25px;
}
```

## 🔍 Testando Acessibilidade

### Validação Manual

1. **Teste sem mouse**
   - Use Tab para navegar
   - Enter para ativar
   - Arrow keys para menu

2. **Teste com leitor de tela**
   - Windows: NVDA (gratuito)
   - Mac: VoiceOver (built-in)
   - Browser: axe DevTools (extensão)

3. **Valide cores**
   - Contraste WCAG AA (4.5:1 mínimo)
   - Use: WebAIM Contrast Checker

### Validação Automática

```javascript
// No console do navegador
DashboardUtils.showToast('Teste de notificação', 'success');

// Verificar eventos
window.addEventListener('click', (e) => {
  console.log('Elemento clicado:', e.target);
});
```

## 📊 Debug e Logging

### Ver Estado da Aplicação

```javascript
// No console
console.log(window.dashboard);        // Instância
console.log(window.DashboardUtils);   // Utilitários
console.log(window.DashboardAnalytics); // Analytics
```

### Rastrear Eventos

```javascript
// Ativar rastreamento
DashboardAnalytics.trackPageView();
DashboardAnalytics.trackUserAction('teste', { param: 'valor' });
```

## 📱 Teste Responsivo

### Chrome DevTools

1. F12 ou Ctrl+Shift+I
2. Ctrl+Shift+M para modo responsivo
3. Testar em diferentes tamanhos:
   - Mobile: 375x667
   - Tablet: 768x1024
   - Desktop: 1920x1080

### Orientações

- ✅ Funciona em portrait
- ✅ Funciona em landscape
- ✅ Sidebar colapsa em mobile
- ✅ Conteúdo legível em todos os tamanhos

## 🚀 Performance

### Checklist

- [ ] CSS não tem seletores muito específicos
- [ ] Sem `!important` no código
- [ ] Animações usam `transform` e `opacity`
- [ ] Cache de elementos DOM
- [ ] Event delegation quando possível
- [ ] Debounce em eventos frequentes

### Medir Performance

```javascript
// No console
performance.mark('inicio');
// código a medir
performance.mark('fim');
performance.measure('teste', 'inicio', 'fim');
console.table(performance.getEntriesByType('measure'));
```

## 🔐 Segurança

### Validação de Entrada

```javascript
// ✅ Bom
const value = userInput.trim();
if (value.length < 3) {
  throw new Error('Mínimo 3 caracteres');
}
element.textContent = value; // Seguro

// ❌ Ruim
element.innerHTML = userInput; // XSS!
```

### Proteção contra XSS

- Use `textContent` ao invés de `innerHTML`
- Valide entrada do usuário
- Sanitize dados dinâmicos

## 📚 Linter e Formatação

### Recomendado para VS Code

1. **Prettier** - Formatação automática
   ```json
   {
     "editor.defaultFormatter": "esbenp.prettier-vscode",
     "editor.formatOnSave": true
   }
   ```

2. **ESLint** - Validação JavaScript
   ```json
   {
     "eslint.validate": ["javascript"],
     "eslint.run": "onSave"
   }
   ```

3. **Stylelint** - Validação CSS
   ```json
   {
     "stylelint.enable": true
   }
   ```

## 🤝 Padrões de Commit

```bash
# Formato: <tipo>(<escopo>): <descrição>

git commit -m "feat(css): adiciona novo componente badge"
git commit -m "fix(js): corrige bug no menu mobile"
git commit -m "docs(readme): atualiza documentação"
git commit -m "style(css): refatora cores com variáveis"
git commit -m "refactor(js): extrai método utilitário"
git commit -m "test: adiciona testes de acessibilidade"
```

## 📋 Checklist Pré-Commit

- [ ] Código segue BEM em CSS
- [ ] Sem console.log() em produção
- [ ] Comentários JSDoc completos
- [ ] Testado em diferentes tamanhos
- [ ] Acessibilidade verificada
- [ ] Sem conflitos de merge
- [ ] Commit message descritiva

## 🐛 Reportar Issues

### Template de Issue

```markdown
## Descrição
Breve descrição do problema

## Passos para Reproduzir
1. Passo 1
2. Passo 2

## Comportamento Esperado
O que deveria acontecer

## Comportamento Atual
O que está acontecendo

## Screenshots
Se aplicável

## Ambiente
- Navegador: 
- SO:
- Tamanho da tela:
```

## 📖 Recursos Úteis

### Documentação
- [MDN Web Docs](https://developer.mozilla.org)
- [W3C HTML Spec](https://html.spec.whatwg.org)
- [CSS Tricks](https://css-tricks.com)
- [WCAG Guidelines](https://www.w3.org/WAI/WCAG21/quickref/)

### Ferramentas
- [Can I Use](https://caniuse.com) - Compatibilidade
- [WebAIM](https://webaim.org) - Acessibilidade
- [CSS Stats](https://www.cssstats.com) - Análise CSS
- [Web.dev](https://web.dev) - Performance

## ✨ Melhores Práticas ao Contribuir

1. **Pequenos commits** - Uma mudança por vez
2. **Testes locais** - Sempre testar antes de commit
3. **Documentação** - Comentar código complexo
4. **Performance** - Pensar em impacto
5. **Acessibilidade** - Nunca quebrar WCAG
6. **Compatibilidade** - Testar navegadores
7. **Código limpo** - Legível e manutenível

## 🎓 Aprendizado Contínuo

- Leia o código existente
- Estude os padrões usados
- Contribua incrementalmente
- Peça feedback
- Revise PRs de outros
- Documente suas aprendizagens

---

**Obrigado por contribuir!** ✨

Qualquer dúvida, consulte a documentação ou abra uma issue.
