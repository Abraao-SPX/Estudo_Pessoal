/**
 * PJBruno Dashboard - JavaScript Module
 * Professional dashboard interactions and utilities
 * @version 1.0.0
 */

(function() {
  'use strict';

  /**
   * Dashboard Application Main Module
   */
  class Dashboard {
    constructor() {
      this.initializeElements();
      this.attachEventListeners();
      this.initializeToggles();
    }

    /**
     * Cache DOM elements for better performance
     */
    initializeElements() {
      this.sidebar = document.querySelector('.sidebar');
      this.menuItems = document.querySelectorAll('.menu__link');
      this.main = document.querySelector('.main');
      this.chartBars = document.querySelectorAll('.chart__bar');
      this.transactionItems = document.querySelectorAll('.transaction-item');
      this.tableRows = document.querySelectorAll('.table__row');
    }

    /**
     * Attach event listeners to interactive elements
     */
    attachEventListeners() {
      // Menu item click handlers
      this.menuItems.forEach((item) => {
        item.addEventListener('click', (e) => this.handleMenuClick(e));
      });

      // Chart bar interactions
      this.chartBars.forEach((bar) => {
        bar.addEventListener('mouseenter', (e) => this.handleChartBarHover(e));
        bar.addEventListener('mouseleave', (e) => this.handleChartBarLeave(e));
      });

      // Transaction item interactions
      this.transactionItems.forEach((item) => {
        item.addEventListener('click', (e) => this.handleTransactionClick(e));
      });

      // Keyboard accessibility for menu
      document.addEventListener('keydown', (e) => this.handleKeyboardNavigation(e));
    }

    /**
     * Initialize UI toggle functionality
     */
    initializeToggles() {
      // Mobile menu toggle (if needed)
      const menuToggle = document.querySelector('[aria-haspopup="true"]');
      if (menuToggle) {
        menuToggle.addEventListener('click', () => this.toggleSidebar());
      }

      // Responsive sidebar for smaller screens
      this.setupResponsiveSidebar();
    }

    /**
     * Handle menu item selection
     * @param {Event} event
     */
    handleMenuClick(event) {
      event.preventDefault();
      const clickedItem = event.currentTarget;

      // Remove active state from all items
      this.menuItems.forEach((item) => {
        item.classList.remove('menu__link--active');
        item.setAttribute('aria-current', 'false');
      });

      // Add active state to clicked item
      clickedItem.classList.add('menu__link--active');
      clickedItem.setAttribute('aria-current', 'page');

      // Log navigation for analytics purposes
      const itemText = clickedItem.querySelector('.menu__text')?.textContent || 'Unknown';
      console.log(`Navigation: ${itemText}`);

      // Close sidebar on mobile
      if (window.innerWidth < 1024) {
        this.closeSidebar();
      }
    }

    /**
     * Handle chart bar interactions
     * @param {Event} event
     */
    handleChartBarHover(event) {
      const bar = event.target;
      bar.classList.add('chart__bar--highlighted');

      // Optional: Show tooltip
      const height = bar.style.height;
      const title = document.createElement('div');
      title.textContent = height;
      title.style.position = 'absolute';
      title.style.top = '-30px';
      title.style.left = '0';
      title.style.fontSize = '12px';
      title.style.color = 'var(--color-primary)';
    }

    /**
     * Handle chart bar leave
     * @param {Event} event
     */
    handleChartBarLeave(event) {
      const bar = event.target;
      bar.classList.remove('chart__bar--highlighted');
    }

    /**
     * Handle transaction item interactions
     * @param {Event} event
     */
    handleTransactionClick(event) {
      const transactionItem = event.currentTarget;
      const date = transactionItem.querySelector('.transaction-item__date')?.textContent;
      const value = transactionItem.querySelector('.transaction-item__value')?.textContent;

      console.log(`Transaction selected: ${date} - ${value}`);

      // Visual feedback
      transactionItem.style.opacity = '0.7';
      setTimeout(() => {
        transactionItem.style.opacity = '1';
      }, 200);
    }

    /**
     * Handle keyboard navigation
     * @param {KeyboardEvent} event
     */
    handleKeyboardNavigation(event) {
      const { key } = event;
      const menuItemsList = Array.from(this.menuItems);
      const currentFocused = document.activeElement;
      const currentIndex = menuItemsList.indexOf(currentFocused);

      if (key === 'ArrowDown' && currentIndex !== -1 && currentIndex < menuItemsList.length - 1) {
        event.preventDefault();
        menuItemsList[currentIndex + 1].focus();
      } else if (key === 'ArrowUp' && currentIndex > 0) {
        event.preventDefault();
        menuItemsList[currentIndex - 1].focus();
      } else if (key === 'Enter' && currentFocused.classList.contains('menu__link')) {
        event.preventDefault();
        currentFocused.click();
      }
    }

    /**
     * Toggle sidebar visibility
     */
    toggleSidebar() {
      this.sidebar.classList.toggle('is-open');
    }

    /**
     * Open sidebar
     */
    openSidebar() {
      this.sidebar.classList.add('is-open');
    }

    /**
     * Close sidebar
     */
    closeSidebar() {
      this.sidebar.classList.remove('is-open');
    }

    /**
     * Setup responsive sidebar behavior
     */
    setupResponsiveSidebar() {
      const mediaQuery = window.matchMedia('(max-width: 1024px)');

      const handleMediaChange = (e) => {
        if (e.matches) {
          // Mobile view
          this.closeSidebar();
        } else {
          // Desktop view
          this.openSidebar();
        }
      };

      mediaQuery.addEventListener('change', handleMediaChange);
    }
  }

  /**
   * Utility functions for common operations
   */
  class DashboardUtils {
    /**
     * Format currency value
     * @param {number} value
     * @param {string} currency
     * @returns {string}
     */
    static formatCurrency(value, currency = 'BRL') {
      return new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: currency,
      }).format(value);
    }

    /**
     * Format date
     * @param {Date|string} date
     * @param {string} format
     * @returns {string}
     */
    static formatDate(date, format = 'pt-BR') {
      const dateObj = typeof date === 'string' ? new Date(date) : date;
      return dateObj.toLocaleDateString(format);
    }

    /**
     * Format percentage
     * @param {number} value
     * @returns {string}
     */
    static formatPercentage(value) {
      return `${(value * 100).toFixed(2)}%`;
    }

    /**
     * Debounce function for performance
     * @param {Function} func
     * @param {number} wait
     * @returns {Function}
     */
    static debounce(func, wait = 300) {
      let timeout;
      return function executedFunction(...args) {
        const later = () => {
          clearTimeout(timeout);
          func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
      };
    }

    /**
     * Throttle function for performance
     * @param {Function} func
     * @param {number} limit
     * @returns {Function}
     */
    static throttle(func, limit = 300) {
      let inThrottle;
      return function (...args) {
        if (!inThrottle) {
          func.apply(this, args);
          inThrottle = true;
          setTimeout(() => (inThrottle = false), limit);
        }
      };
    }

    /**
     * Show toast notification
     * @param {string} message
     * @param {string} type
     * @param {number} duration
     */
    static showToast(message, type = 'info', duration = 3000) {
      const toast = document.createElement('div');
      toast.textContent = message;
      toast.style.position = 'fixed';
      toast.style.bottom = '20px';
      toast.style.right = '20px';
      toast.style.padding = 'var(--spacing-lg)';
      toast.style.borderRadius = 'var(--radius-md)';
      toast.style.backgroundColor =
        type === 'success' ? 'var(--color-success)' : 'var(--color-primary)';
      toast.style.color = 'white';
      toast.style.zIndex = '10000';
      toast.style.boxShadow = 'var(--shadow-lg)';
      toast.style.fontFamily = 'var(--font-primary)';

      document.body.appendChild(toast);

      setTimeout(() => {
        toast.remove();
      }, duration);
    }
  }

  /**
   * Analytics helper for tracking user interactions
   */
  class DashboardAnalytics {
    static trackEvent(eventName, eventData = {}) {
      const event = {
        name: eventName,
        timestamp: new Date().toISOString(),
        userAgent: navigator.userAgent,
        data: eventData,
      };

      console.log('Event tracked:', event);
      // Here you would send to analytics service
    }

    static trackPageView() {
      this.trackEvent('page_view', {
        page: document.title,
        url: window.location.href,
      });
    }

    static trackUserAction(action, details = {}) {
      this.trackEvent('user_action', {
        action: action,
        details: details,
        timestamp: new Date(),
      });
    }
  }

  /**
   * Initialize dashboard when DOM is ready
   */
  document.addEventListener('DOMContentLoaded', () => {
    // Initialize main dashboard
    window.dashboard = new Dashboard();

    // Track initial page view
    DashboardAnalytics.trackPageView();

    // Example: Show welcome toast
    DashboardUtils.showToast('Dashboard carregado com sucesso!', 'success');

    console.log('Dashboard initialized successfully');
  });

  /**
   * Expose utilities globally for use in HTML
   */
  window.DashboardUtils = DashboardUtils;
  window.DashboardAnalytics = DashboardAnalytics;
})();
