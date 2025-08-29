document.addEventListener('DOMContentLoaded', function() {
    // Navbar scroll effect
    const navbar = document.querySelector('.navbar');
    window.addEventListener('scroll', function() {
        if (window.scrollY > 50) {
            navbar.classList.add('navbar-scrolled');
            navbar.style.padding = '0.5rem 0';
        } else {
            navbar.classList.remove('navbar-scrolled');
            navbar.style.padding = '0.8rem 0';
        }
    });

    // Search functionality
    const searchForm = document.querySelector('.search-form');
    if (searchForm) {
        const searchInput = searchForm.querySelector('.search-input');

        // Focus effect
        searchInput.addEventListener('focus', function() {
            this.parentElement.classList.add('focused');
        });

        searchInput.addEventListener('blur', function() {
            this.parentElement.classList.remove('focused');
        });

        // Form submission
        searchForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const searchTerm = searchInput.value.trim();
            if (searchTerm) {
                alert(`Searching for: ${searchTerm}`);
                // In real implementation:
                // window.location.href = `/search?q=${encodeURIComponent(searchTerm)}`;
            }
        });

        // Instant search (optional)
        searchInput.addEventListener('input', function(e) {
            console.log('Search query:', e.target.value);
            // Here you would typically make API calls for live search results
        });
    }

    // Cart badge animation
    const cartBadge = document.querySelector('.badge');
    if (cartBadge) {
        cartBadge.addEventListener('click', function(e) {
            e.preventDefault();
            this.classList.add('animate__animated', 'animate__bounce');
            setTimeout(() => {
                this.classList.remove('animate__animated', 'animate__bounce');
            }, 1000);
        });
    }
});