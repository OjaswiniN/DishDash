CREATE TABLE IF NOT EXISTS restaurants (
    id VARCHAR(24) PRIMARY KEY,
    restaurant_id VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(255),
    image_url TEXT,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    attributes TEXT[], -- Array of attributes (e.g., 'Chinese', 'Fast Food', 'Bakery')
    opens_at TIME, -- Time format for opening time (e.g., 11:00, 03.16)
    closes_at TIME
);

CREATE TABLE IF NOT EXISTS items (
    id VARCHAR(24) PRIMARY KEY,
    item_id VARCHAR(50) UNIQUE NOT NULL,
    name TEXT NOT NULL,
    image_url TEXT,
    price float NOT NULL,
    attributes TEXT[]
);
